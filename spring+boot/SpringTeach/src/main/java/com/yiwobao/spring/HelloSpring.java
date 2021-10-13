package com.yiwobao.spring;

import com.yiwobao.dao.SpringAction;
import com.yiwobao.pojo.Person1;
import com.yiwobao.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {


    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
       /* User bean = applicationContext.getBean(User.class);*/
        User constructor = (User)applicationContext.getBean("constructor");
        System.out.println(constructor);
        SpringAction staticFactory = (SpringAction) applicationContext.getBean("staticFactory");
        staticFactory.staticFactoryOk();

        Person1 person = (Person1) applicationContext.getBean("person");
        System.out.println(person);

    }

}
