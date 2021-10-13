package com.yiwobao.aop.service;

public interface CustomerService {

  /*  void save(); 用来测试第一个aop程序*/

     void save(String  name);

     void update(); //

     /**
      * 模拟转账方法
      */
      Double transfer(Double money);
}
