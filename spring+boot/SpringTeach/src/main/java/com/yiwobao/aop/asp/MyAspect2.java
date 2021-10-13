package com.yiwobao.aop.asp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect2 {
    @Before(value="execution(public * com.yiwobao.aop.dao.CustomerServiceImpl.*(..))")
    public void writeLog(){
        System.out.println("SpringAOP注解记录日志");
    }
}
