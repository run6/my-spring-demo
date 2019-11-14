package com.idanchuang.shop.user.sys.controller;


import com.idanchuang.shop.user.sys.entity.Users;
import com.idanchuang.shop.user.sys.service.IUsersService;
import com.idanchuang.shop.user.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") Integer id){

        var user =  usersService.getById(id);
        return  user;
    }

    @PostMapping
    public Integer  insert(Users users) {
        usersService.save(users);
        System.out.println(users);
        return users.getId();
    }
}
