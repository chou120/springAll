package com.yiwobao.annotation.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
/**
    spring连接数据库相关的配置类
 * @Value
 *      作用: 用于注入基本类型和String类型的数据
 *      属性:
 *          value: 用于指定数据的值. 它可以使用spring中SpEL(也就是spring的el表达式)
 *          SpEL的写法: ${表达式}
 *
 *@Qualifier:(不能独立使用, 依赖@Autowired)
 *         作用: 在按照类中注入的基础之上在按照名称注入. 它在给类成员注入时不能单独使用. 但是在给方法参数注入时可以
 *         属性:
 *             value: 用于指定注入bean的id.
 *
 */

@Configuration
@PropertySource("classpath:JDBC.properties")
public class DBUtil {

    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${driverClass}")
    private String driverClass;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;


    /**
     * 用于创建 QueryRunner
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope("prototype") // 这里用Qualifier注解是防止有多个bean对象都满足时, 报错, 这里给指定一个id, 根据id来找bean对象
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        return new QueryRunner(dataSource);
    }


    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driverClass);
            ds.setJdbcUrl(jdbcUrl);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }


}
