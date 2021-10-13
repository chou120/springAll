package com.yiwobao.transactionXml.test;


import com.yiwobao.transactionXml.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo {
    /**
     * 添加操作
     */
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "applicationContext8-annotation.xml");
        AccountService accountService = (AccountService)ac.getBean("accountService");
        accountService.transfer("xiaocang", "cangjing", 300f);
    }
}
