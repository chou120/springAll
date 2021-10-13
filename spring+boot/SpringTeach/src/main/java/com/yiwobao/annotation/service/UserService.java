package com.yiwobao.annotation.service;

import com.yiwobao.annotation.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    Boolean login(User user);
}
