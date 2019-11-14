package com.idanchuang.shop.user.controller;

import com.idanchuang.shop.user.models.User;
import com.idanchuang.shop.user.service.UserService;
import com.idanchuang.shop.user.utils.ReturnResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    private final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public User insert(User user) {
        return userService.insert(user);
    }

    @PutMapping("/user/{id}")
    public HashMap update(@PathVariable("id") Long id, User user) {
        try {
            userService.update(id, user);
            return ReturnResult.success();
        } catch (Exception e) {
            return ReturnResult.error();
        }
    }

}
