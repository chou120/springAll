package com.yiwobao.annotation.controller;

import com.yiwobao.annotation.pojo.User;
import com.yiwobao.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public  Boolean login(User user){
        System.out.println("---------->>>>>>>");
     return    userService.login(user);
    }


}
