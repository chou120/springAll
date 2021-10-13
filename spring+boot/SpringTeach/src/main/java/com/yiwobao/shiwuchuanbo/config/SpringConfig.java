package com.yiwobao.shiwuchuanbo.config;

import com.yiwobao.shiwuchuanbo.util.DBUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.yiwobao.shiwuchuanbo"})
@Import(DBUtil.class)
@EnableTransactionManagement  //纯注解需要此注解开启事务
public class SpringConfig {
}
