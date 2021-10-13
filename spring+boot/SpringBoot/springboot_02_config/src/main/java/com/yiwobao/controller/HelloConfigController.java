package com.yiwobao.controller;

import com.yiwobao.pojo.Person;
import com.yiwobao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConfigController {
    @Autowired
    private Student student;
    @Autowired
    private Person person;

    @RequestMapping("/config")
    public Person helloConfig(){
        System.out.println("----"+person.toString());
        return person;
    }

}
