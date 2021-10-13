package com.yiwobao.shiwuchuanbo.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

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

    @Bean("jdbcTemplate")
    @Scope("prototype")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    //创建事务管理器
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
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
