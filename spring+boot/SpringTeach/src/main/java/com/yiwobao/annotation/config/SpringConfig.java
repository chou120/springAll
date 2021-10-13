package com.yiwobao.annotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yiwobao.annotation.util.DBUtil;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@Import(value = DBUtil.class)
@PropertySource(value = "classpath:JDBC.properties")
@ComponentScan(basePackages = {"com.yiwobao.annotation"})//配置包扫描
public class SpringConfig {

}
