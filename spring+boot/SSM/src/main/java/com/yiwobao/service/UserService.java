package com.yiwobao.service;

import com.yiwobao.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     */
     List<User> findAll();
}
