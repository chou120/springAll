package com.yiwobao.shiwuchuanbo.dao;

import com.yiwobao.shiwuchuanbo.pojo.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("user1DaoImpl")
public class User1DaoImpl implements User1Dao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(User1 record) {
        String sql="insert into user1 values (?,?);";
        return jdbcTemplate.update(sql,record.getId(),record.getName());
    }

    @Override
    public User1 selectByPrimaryKey(Integer id) {
        return null;
    }
}
