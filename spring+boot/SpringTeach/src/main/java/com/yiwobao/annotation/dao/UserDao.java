package com.yiwobao.annotation.dao;

import com.yiwobao.annotation.pojo.User;
import org.springframework.stereotype.Repository;

public interface UserDao {
  Boolean  login(User user);
}
