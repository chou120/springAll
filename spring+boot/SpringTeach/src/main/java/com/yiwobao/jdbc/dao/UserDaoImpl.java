package com.yiwobao.jdbc.dao;

import com.yiwobao.jdbc.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void setDataSource(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }
    @Override
    public void createUserTable() {
        this.jdbcTemplate.execute("CREATE TABLE `user` (\r\n" + "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
                + "  `name` varchar(50) DEFAULT NULL,\r\n" + "  `age` int(11) DEFAULT NULL,\r\n"
                + "  PRIMARY KEY (`id`)\r\n" + ")");
    }
    @Override
    public void saveUser(User user) {
        this.jdbcTemplate.update("INSERT INTO USER(NAME,age) VALUES (?,?)", user.getName(), user.getAge());
    }
    @Override
    public List<User> listUser() {
        List<User> users = this.jdbcTemplate.query("SELECT NAME,age FROM USER", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return users;
    }

}
