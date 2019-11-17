package com.idanchuang.shop.user.sys.service.impl;

import com.idanchuang.shop.user.exception.ResultException;
import com.idanchuang.shop.user.sys.entity.Users;
import com.idanchuang.shop.user.sys.mapper.UsersMapper;
import com.idanchuang.shop.user.sys.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mr
 * @since 2019-11-14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {


    private final
    UsersMapper usersMapper;

    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public boolean save(Users entity) {
        // 将密码加密后存储
        entity.setPassword((new BCryptPasswordEncoder()).encode(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public Users checkEmailPassword(String email, String password) throws ResultException {
        // 通过邮箱找到对应的用户
        var user = usersMapper.getUserByEmail(email);
        // 如果用户存在 并且 密码能匹配上
        if (user != null && (new BCryptPasswordEncoder()).matches(password, user.getPassword())) {
            return user;
        }
        throw new ResultException("邮箱或密码错误");
    }
}
