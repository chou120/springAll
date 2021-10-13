package com.yiwobao.springboot_11_plus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiwobao.springboot_11_plus.mapper.UserMapper;
import com.yiwobao.springboot_11_plus.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
