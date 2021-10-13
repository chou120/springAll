package com.yiwobao.dao;

public class DaoFactory {
    //静态工厂
    public static final UserDao getStaticUserDaoImpl(){
        return new UserDao();
    }

}
