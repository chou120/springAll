package com.yiwobao.aop.test;

import com.yiwobao.aop.config.SpringConfig;
import com.yiwobao.aop.dao.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfig.class)
public class Demo1 {
    @Autowired
    private CustomerService customerService;
    @Test
    public void test1(){
        customerService.update();
    }
}
