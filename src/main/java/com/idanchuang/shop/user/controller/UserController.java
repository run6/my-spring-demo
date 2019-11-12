package com.idanchuang.shop.user.controller;

import com.idanchuang.shop.user.dao.UserMapper;
import com.idanchuang.shop.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final
    UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
