package com.yiwobao.annotation;

import com.yiwobao.annotation.config.SpringConfig;
import com.yiwobao.annotation.controller.UserController;
import com.yiwobao.annotation.dao.CustomerDao;
import com.yiwobao.annotation.dao.CustomerDaoImpl;
import com.yiwobao.annotation.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    public static void main(String[] args) {
       /* ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext3-annotation.xml");
        UserController userController = (UserController)ctx.getBean("userController");
        User user = (User) ctx.getBean("user");
        user.setUname("zhangsan");
        user.setPassword("123");

        System.out.println(userController.login(user));*/

        ApplicationContext ac =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerDao bean1 = (CustomerDao) ac.getBean("customerDao");
        bean1.add(new User("zhangsan","12312"));

    }

}
