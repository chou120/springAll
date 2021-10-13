package com.yiwobao.spring;

import com.yiwobao.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2-Beans.xml");
        Person person = (Person) context.getBean("person");
        person.man();
    }
}
