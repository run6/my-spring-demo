package com.idanchuang.shop.user.service.impl;

import com.idanchuang.shop.user.dao.UserMapper;
import com.idanchuang.shop.user.models.User;
import com.idanchuang.shop.user.models.UserExample;
import com.idanchuang.shop.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {
        UserExample example = new UserExample();

        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNicknameEqualTo("lion");
        example.or().andGenderEqualTo(1);
        example.setOrderByClause("create_time desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public User insert(User user) {
        var id = userMapper.insertSelective(user);
        user.setId((long)id);
        return user;
    }

    @Override
    public User update(Long id, User user) {
        user.setId(id);
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }
}
