package com.yiwobao.shiwuchuanbo.service;

import com.yiwobao.shiwuchuanbo.dao.User1Dao;
import com.yiwobao.shiwuchuanbo.pojo.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("user1ServiceImpl")
public class User1ServiceImpl implements User1Service{

    @Resource
    @Qualifier("user1DaoImpl")
    private User1Dao user1Dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user){
        user1Dao.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiredNew(User1 user) {
        user1Dao.insert(user);
    }

}
