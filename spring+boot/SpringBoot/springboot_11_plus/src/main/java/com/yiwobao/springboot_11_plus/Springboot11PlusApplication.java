package com.yiwobao.springboot_11_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yiwobao.springboot_11_plus.mapper")
public class Springboot11PlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot11PlusApplication.class, args);
    }

}
