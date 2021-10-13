package com.yiwobao.aop.dao;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public void save(String name) {
        System.out.println("执行save方法,name为："+name);
    }

    @Override
    public void update() {
        System.out.println("执行update方法");
    }
}
