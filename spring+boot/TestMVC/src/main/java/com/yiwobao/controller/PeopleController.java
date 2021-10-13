package com.yiwobao.controller;

import com.yiwobao.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PeopleController {
    /**
     * 登录页面初始化
     */
    @RequestMapping("/toLogin")
    public String initLogin() {
        return "InterceptorLogin";
    }
    /**
     * 处理登录功能
     */
    @RequestMapping("/login")
    public String login(People user, Model model, HttpSession session) {
        System.out.println(user.getUsername());
        if ("yiwobao".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            // 登录成功，将用户信息保存到session对象中
            session.setAttribute("user", user);
            // 重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！ ");
        return "InterceptorLogin";
    }
    /**
     * 跳转到主页面
     */
    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }
    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除 session
        session.invalidate();
        return "InterceptorLogin";
    }
}
