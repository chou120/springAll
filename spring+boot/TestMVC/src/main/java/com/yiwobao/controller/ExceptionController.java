package com.yiwobao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ExceptionController {

    @RequestMapping("/helloException")
    public String upload(HttpSession session, HttpServletResponse response) throws Exception {
        //模拟异常
        int i = 100/0;
        return "success";
    }
}
