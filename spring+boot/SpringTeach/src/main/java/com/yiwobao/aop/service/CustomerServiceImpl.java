package com.yiwobao.aop.service;

import org.springframework.stereotype.Repository;

@Repository("customerService")
public class CustomerServiceImpl implements CustomerService{

    @Override
    public void save(String name) {
        System.out.println("执行save方法,name为："+name);
        System.out.println(1/0);
    }

    @Override
    public void update() {
        System.out.println("执行update方法");
    }

    @Override
    public Double transfer(Double money) {
        System.out.println("给苍老师转账了"+money+"元");
        return money;
    }
}
