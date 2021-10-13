package com.yiwobao.aop.test;

import com.yiwobao.aop.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext4-aop.xml")
public class TestAop {

    @Autowired
    private CustomerService customerService;

    @Test
    public void  testAop(){
       /* customerService.save("张三");
        customerService.update();*/
        customerService.transfer(1000D);
    }

}
