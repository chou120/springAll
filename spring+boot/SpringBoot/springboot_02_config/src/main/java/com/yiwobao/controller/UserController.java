package com.yiwobao.controller;

import com.yiwobao.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/validUser")
public class UserController {
    @RequestMapping("/user")
    public Map<String,Object> save (@Valid User user , BindingResult bindingResult)  {
        Map<String , Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            System.out.println("tomcat");
            bindingResult.getFieldErrors().forEach( (item) -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put( field , message );
            } );
            return map;
        }
        map.put("status","添加成功");
       return map;
    }
}
