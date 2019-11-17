package com.idanchuang.shop.user.sys.controller;


import com.idanchuang.shop.user.sys.entity.Users;
import com.idanchuang.shop.user.sys.service.IUsersService;
import com.idanchuang.shop.user.utils.ReturnResult;
import com.idanchuang.shop.user.utils.Token;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mr
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/sys/users")
public class UsersController {
    private final
    IUsersService usersService;

    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * 获取当前用户信息
     */
    @GetMapping
    public ReturnResult getUserById() {
        return ReturnResult.success(Token.user);
    }

    /**
     * 创建一个新用户
     * @param users 用户信息
     */
    @PostMapping
    public ReturnResult insert(@RequestBody @Validated Users users) {
        usersService.save(users);
        return ReturnResult.success();
    }

}
