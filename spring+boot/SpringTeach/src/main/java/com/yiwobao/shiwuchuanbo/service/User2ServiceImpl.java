package com.yiwobao.shiwuchuanbo.service;

import com.yiwobao.shiwuchuanbo.dao.User1Dao;
import com.yiwobao.shiwuchuanbo.dao.User2Dao;
import com.yiwobao.shiwuchuanbo.pojo.User1;
import com.yiwobao.shiwuchuanbo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("user2ServiceImpl")
public class User2ServiceImpl implements User2Service{

    @Resource
    @Qualifier("user2DaoImpl")
    private User2Dao user2Dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User2 user){
        user2Dao.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredException(User2 user){
        user2Dao.insert(user);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNew(User2 user){
        user2Dao.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredExceptionNew(User2 user){
        user2Dao.insert(user);
        throw new RuntimeException();
    }

}
