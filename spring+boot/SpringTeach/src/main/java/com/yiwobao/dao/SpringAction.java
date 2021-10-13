package com.yiwobao.dao;

public class SpringAction {
//现在让spring管理
    //注入对象
    private UserDao daoFactory;

    public void setDaoFactory(UserDao daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void staticFactoryOk(){
        daoFactory.saveUserDao();
    }


}
