package com.yiwobao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/torest")
    public String torest() {
        return "rest";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable Integer id) {
        System.out.println("test rest get:" + id);
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String hello() {
        System.out.println("test POST:");
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String helloDelete(@PathVariable Integer id) {
        System.out.println("test rest delete:" + id);
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String helloPUt(@PathVariable Integer id) {
        System.out.println("test rest put:" + id);
        return "success";
    }
}