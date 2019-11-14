package com.idanchuang.shop.user.service;

import com.idanchuang.shop.user.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();

    User insert(User user);

    User update(Long id, User user);
}
