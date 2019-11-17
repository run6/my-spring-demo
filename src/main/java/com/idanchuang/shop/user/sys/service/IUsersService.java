package com.idanchuang.shop.user.sys.service;

import com.idanchuang.shop.user.exception.ResultException;
import com.idanchuang.shop.user.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mr
 * @since 2019-11-14
 */
public interface IUsersService extends IService<Users> {
    /**
     * 通过邮箱和密码来校验用户
     */
    Users checkEmailPassword(String email, String password) throws ResultException;
}
