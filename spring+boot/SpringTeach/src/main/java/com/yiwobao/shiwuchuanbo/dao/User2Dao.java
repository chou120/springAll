package com.yiwobao.shiwuchuanbo.dao;

import com.yiwobao.shiwuchuanbo.pojo.User2;

public interface User2Dao {
    int insert(User2 record);
    User2 selectByPrimaryKey(Integer id);
}
