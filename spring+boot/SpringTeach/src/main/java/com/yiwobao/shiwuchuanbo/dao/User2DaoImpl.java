package com.yiwobao.shiwuchuanbo.dao;

import com.yiwobao.shiwuchuanbo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("user2DaoImpl")
public class User2DaoImpl implements User2Dao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(User2 record) {
        String sql="insert into user2 values (?,?);";
        return jdbcTemplate.update(sql,record.getId(),record.getName());
    }

    @Override
    public User2 selectByPrimaryKey(Integer id) {
        return null;
    }
}
