package com.yiwobao.spring;

import com.yiwobao.aop.dao.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext5-aopAnnotation.xml")
public class Demo1 {

    @Resource
    private CustomerService customerService;

    @Test
    public void test1(){
        customerService.update();
    }
}