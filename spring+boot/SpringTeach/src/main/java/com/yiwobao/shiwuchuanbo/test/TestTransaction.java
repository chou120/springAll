package com.yiwobao.shiwuchuanbo.test;

import com.yiwobao.shiwuchuanbo.config.SpringConfig;
import com.yiwobao.shiwuchuanbo.controller.TransactionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestTransaction {
    @Autowired
    private TransactionController transactionController;
    @Test
    public  void   test(){
       //transactionController.notransaction_exception_required_required1();
      // transactionController.notransaction_required_required_exception2();
      // transactionController.transaction_exception_required_required3();
     //  transactionController.transaction_required_required_exception4();
        //  transactionController.transaction_required_required_exception_try5();
        //transactionController.notransaction_exception_requiresNew_requiresNew();
        //transactionController.notransaction_requiresNew_requiresNew_exception();
       // transactionController.transaction_exception_required_requiresNew_requiresNew();
        transactionController.transaction_required_requiresNew_requiresNew_exception();
       // transactionController.transaction_required_requiresNew_requiresNew_exception_try();


    }

}
