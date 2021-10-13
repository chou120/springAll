package com.yiwobao.springboot_03_thymeleaf;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Springboot03ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ThymeleafApplication.class, args);
    }

}
