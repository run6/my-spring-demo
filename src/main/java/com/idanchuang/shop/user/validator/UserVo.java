package com.idanchuang.shop.user.validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserVo {
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
