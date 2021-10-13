package com.yiwobao.aop.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@ComponentScan(basePackages="com.yiwobao.aop")
@EnableAspectJAutoProxy  // 开启AOP注解功能
public class SpringConfig {
}
