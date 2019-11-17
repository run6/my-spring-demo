package com.idanchuang.shop.user.sys.controller;

import com.idanchuang.shop.user.annotation.PassToken;
import com.idanchuang.shop.user.exception.ResultException;
import com.idanchuang.shop.user.sys.service.IUsersService;
import com.idanchuang.shop.user.utils.ReturnResult;
import com.idanchuang.shop.user.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;

@RestController
@RequestMapping("/sys/login")
@Validated
public class LoginController {

    private final
    IUsersService usersService;

    public LoginController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @PassToken
    @PostMapping
    public ReturnResult login(@NotEmpty(message = "邮箱必填") @Email(message = "邮箱格式错误") String email, @NotEmpty(message = "密码必填") String password) throws ResultException {
        var user = usersService.checkEmailPassword(email, password);
        var token = Token.getToken(user);
        var res = new HashMap<>();
        res.put("token", token);
        return ReturnResult.success(res);
    }
}
