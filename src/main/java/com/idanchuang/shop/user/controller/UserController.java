package com.idanchuang.shop.user.controller;

import com.idanchuang.shop.user.ReturnResult;
import com.idanchuang.shop.user.dao.UserMapper;
import com.idanchuang.shop.user.models.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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

    @PostMapping("/user")
    public HashMap insertUser(User user){
        var res = new HashMap<>();
        res.put("id", userMapper.insert(user));

        return ReturnResult.creat(Response.SC_OK,"操作成功",res);
    }
}
