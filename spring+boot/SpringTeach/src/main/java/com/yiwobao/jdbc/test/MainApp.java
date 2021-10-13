package com.yiwobao.jdbc.test;

import com.yiwobao.jdbc.dao.UserDao;
import com.yiwobao.jdbc.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6-jdbcBeans.xml");
        UserDao dao = (UserDao) ctx.getBean("userdao");
        dao.createUserTable();
        dao.saveUser(new User("qinjin", 12));
        dao.saveUser(new User("baiduwang", 18));
        List<User> users = dao.listUser();
        for (User user : users) {
            System.out.println("姓名：" + user.getName() + "\t年龄：" + user.getAge());
        }
    }

}
