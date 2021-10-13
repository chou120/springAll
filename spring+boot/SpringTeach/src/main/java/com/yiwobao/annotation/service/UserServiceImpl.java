package com.yiwobao.annotation.service;

import com.yiwobao.annotation.dao.UserDao;
import com.yiwobao.annotation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /*引用实例名称*/
   /* @Resource(name = "userDao")
    private UserDao userDao;*/

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Boolean login(User user) {

        return userDao.login(user);
    }
}
