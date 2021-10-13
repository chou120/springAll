package com.yiwobao.springboot_12_plus_gen.service.impl;

import com.yiwobao.springboot_12_plus_gen.entity.User;
import com.yiwobao.springboot_12_plus_gen.mapper.UserMapper;
import com.yiwobao.springboot_12_plus_gen.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sanye
 * @since 2021-09-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
