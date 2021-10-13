package com.yiwobao.dao;

import com.yiwobao.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有账户
     */
   /* @Select("select * from user")*/
    public List<User> findAll();

}
