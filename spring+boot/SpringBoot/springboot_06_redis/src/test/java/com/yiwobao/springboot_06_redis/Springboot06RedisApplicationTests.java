package com.yiwobao.springboot_06_redis;

import com.yiwobao.springboot_06_redis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

@SpringBootTest
class Springboot06RedisApplicationTests {

   /* @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        //这里相当于redis对String类型的set操作
        redisTemplate.opsForValue().set("ha","hahahaha");
        //这里相当于redis对String类型的get操作
        String test = (String)redisTemplate.opsForValue().get("ha");
        System.out.println(test+"地址:"+redisTemplate.getClientList());
    }
    */


    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        User user = new User(9527L,"张三","123456","白下区",new Date());
        redisTemplate.opsForValue().set("user",user);
        System.out.println(">>>>"+redisTemplate.opsForValue().get("user"));

    }

}
