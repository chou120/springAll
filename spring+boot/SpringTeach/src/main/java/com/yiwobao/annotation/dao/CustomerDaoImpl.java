package com.yiwobao.annotation.dao;

import com.yiwobao.annotation.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private QueryRunner runner;
    @Autowired
    private DataSource dataSource;

    @Override
    public void add(User user) {
        try {
            String  sql="insert into user(`uname`,`password`)value(?,?)";
            Object [] param={user.getUname(),user.getPassword()};
            runner.execute(dataSource.getConnection(),sql,param);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
