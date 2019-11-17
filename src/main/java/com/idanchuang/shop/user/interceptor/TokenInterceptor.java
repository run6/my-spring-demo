package com.idanchuang.shop.user.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.idanchuang.shop.user.annotation.PassToken;
import com.idanchuang.shop.user.exception.ResultException;
import com.idanchuang.shop.user.sys.service.IUsersService;
import com.idanchuang.shop.user.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    IUsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(usersService);
        String token = request.getHeader("token");
        token = token != null ? token : request.getParameter("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        var handleMethod = (HandlerMethod) handler;
        Method method = handleMethod.getMethod();

        //检查是否有passToken注解，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if (token == null) {
            throw new ResultException("权限不足");
        }

        try {
            var claims = Token.verify(token).getClaims();
            var userId = claims.get("userId").asInt();
            var user = usersService.getById(userId);
            if (user == null) {
                throw new ResultException("用户不存在");
            }
            Token.user = user;
        } catch (JWTVerificationException e) {
            throw new ResultException("权限不足");
        }

        return true;
    }
}
