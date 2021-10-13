package com.yiwobao.shiwuchuanbo.controller;

import com.yiwobao.shiwuchuanbo.pojo.User1;
import com.yiwobao.shiwuchuanbo.pojo.User2;
import com.yiwobao.shiwuchuanbo.service.User1Service;
import com.yiwobao.shiwuchuanbo.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Controller
public class TransactionController {

    @Resource
    @Qualifier("user1ServiceImpl")
    private User1Service user1Service;

    @Resource
    @Qualifier("user2ServiceImpl")
    private User2Service user2Service;

    //此场景外围方法没有开启事务。
    public void notransaction_exception_required_required1(){
        User1 user1=new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisi");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    public void notransaction_required_required_exception2(){
        User1 user1=new User1();
        user1.setName("zhangsan222");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisi222");
        user2Service.addRequiredException(user2);
    }


    //外围方法开启事务，这个是使用率比较高的场景。
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_required3(){
        User1 user1=new User1();
        user1.setName("zhangsan1111isTransaction");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisi1111111Transaction");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception4(){
        User1 user1=new User1();
        user1.setName("zhangsan2Transaction");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisi2Transaction");
        user2Service.addRequiredException(user2);
    }

    @Transactional
    public void transaction_required_required_exception_try5(){
        User1 user1=new User1();
        user1.setName("zhangsan3Transaction");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisi3Transaction");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }



    //外围方法没有开启事务。
    public void notransaction_exception_requiresNew_requiresNew(){
        User1 user1=new User1();
        user1.setName("zhangsanNew");
        user1Service.addRequiredNew(user1);

        User2 user2=new User2();
        user2.setName("lisiNew");
        user2Service.addRequiredNew(user2);
        throw new RuntimeException();

    }


    public void notransaction_requiresNew_requiresNew_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequiredNew(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiredExceptionNew(user2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_requiresNew_requiresNew(){
        User1 user1=new User1();
        user1.setName("saner");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("sier");
        user2Service.addRequiredNew(user2);

        User2 user3=new User2();
        user3.setName("wangwu");
        user2Service.addRequiredNew(user3);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNew_exception(){
        User1 user1=new User1();
        user1.setName("zhangsanA");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisiA");
        user2Service.addRequiredNew(user2);

        User2 user3=new User2();
        user3.setName("wangwuA");
        user2Service.addRequiredExceptionNew(user3);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNew_exception_try(){
        User1 user1=new User1();
        user1.setName("zhangsanB");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("lisiB");
        user2Service.addRequiredNew(user2);
        User2 user3=new User2();
        user3.setName("wangwuB");
        try {
            user2Service.addRequiredExceptionNew(user3);
        } catch (Exception e) {
            System.out.println("回滚");
        }
    }
}
