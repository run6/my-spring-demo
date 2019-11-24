package com.idanchuang.shop.user.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
@WebFilter(filterName = "MyFilterWithAnnotation", urlPatterns = "/api/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("初始化过滤器"+ filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("对请求进行预处理: ");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();

        System.out.println("请求的接口:" + requestUri);
        Long startTime = System.currentTimeMillis();
        // 通过doFilter方法来实现过滤功能
        filterChain.doFilter(servletRequest, servletResponse);
        // 上面的doFilter 方法执行完毕 用户的请求已经结束
        Long endTime = System.currentTimeMillis();
        System.out.println("该用户的请求已经处理完毕, 请求花费的时间未: " + (startTime - endTime));

    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }
}
