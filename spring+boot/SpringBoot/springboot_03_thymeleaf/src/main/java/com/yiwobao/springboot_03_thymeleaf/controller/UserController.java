package com.yiwobao.springboot_03_thymeleaf.controller;

import com.yiwobao.springboot_03_thymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class UserController {
    @GetMapping("index")//页面的url地址
    public String getIndex(Model model)//对应函数
    {
        model.addAttribute("name","三爷woshinhahsashashibaba大三泡");
        return "index";//与templates中index.html对应
    }

    @RequestMapping(value="/userinfo")
    public String userinfo (Model model) {
        User user = new User();
        user.setId(1);
        user.setNick("被三炮");
        user.setPhone("13700020000");
        user.setAddress("北京朝阳区");
        user.setBirthday(new Date());
        user.setEmail("120@qq.com");
        model.addAttribute("user", user);
        model.addAttribute("hello", "yiwobao");

        model.addAttribute("sex",1);
        return "user";
    }


    @RequestMapping(value="/userList")
    public String userList (Model model) {
        User user = new User();
        user.setId(2);
        user.setNick("胡三排");
        user.setPhone("22");
        user.setAddress("神龙架");
        user.setBirthday(new Date());
        user.setEmail("220@qq.com");

        User user2 = new User();
        user2.setId(3);
        user2.setNick("婆罗洲");
        user2.setPhone("123423546576");
        user2.setAddress("神龙架2");
        user2.setBirthday(new Date());
        user2.setEmail("220@qq.com");

       // List<User> userList=Arrays.asList(user2,user);
        Map<String, Object> map = new HashMap<>();
        /*model.addAttribute("userList", userList);*/
        map.put("user1",user);
        map.put("user2",user2);

        model.addAttribute("myMap",map);
        model.addAttribute("hello", "yiwobao");

        return "user";
    }


}
