package com.idanchuang.shop.user.sys.mapper;

import com.idanchuang.shop.user.sys.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author mr
 * @since 2019-11-14
 */
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 通过用户账号查询用户信息
     */
    @Select("select * from users where name = #{name}")
    Users getUserByName(@Param("name") String name);


    /**
     * 通过邮箱查询用户信息
     */
    @Select("select * from users where email = #{email}")
    Users getUserByEmail(@Param("email") String email);

}
