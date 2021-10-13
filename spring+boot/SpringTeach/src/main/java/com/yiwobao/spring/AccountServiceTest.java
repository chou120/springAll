package com.yiwobao.spring;

import com.yiwobao.annotation.config.SpringConfiguration;
import com.yiwobao.annotation.pojo.Account;
import com.yiwobao.annotation.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Spring整合junit的配置
 *      1. 导入spring整合junit的jar(坐标)
 *      2. 使用junit提供的一个注解把原有的main方法替换了, 替换成spring提供的
 *          @Runwith
 *      3. 告知spring的运行器, spring和ioc的创建基于xml还是注解的, 并且说明位置
 *          @ContextConfiguration
 *              locations: 指定xml文件的位置, 加上classpath关键字, 表示在类路径下
 *              classes: 指定注解类所在的位置
 *
 * 当我们使用spring 5.x版本的时候, 要求junit的jar必须是4.12及以上版本
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void findAllTest() {
        // 1. 执行方法
        List<Account> allAccount = accountService.findAllAccount();

        for (Account account : allAccount) {
            System.out.println(account);
        }

    }

    @Test
    public void findOneTest() {
        // 1. 执行方法
        Account account = accountService.findAccountById(1);

        System.out.println(account);

    }

    @Test
    public void saveAccountTest() {
        // 1. 构造对象
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(2000.0);

        // 2. 执行方法
        accountService.saveAccount(account);

    }

    @Test
    public void updateAccountTest() {
        // 1. 构造对象
        Account account = new Account();
        account.setId(3);
        account.setName("ddd");
        account.setMoney(2000.9);

        // 2. 执行方法
        accountService.updateAccount(account);

    }

    @Test
    public void deleteAccountTest() {
        // 1. 执行方法
        accountService.deleteAccount(3);

    }
}