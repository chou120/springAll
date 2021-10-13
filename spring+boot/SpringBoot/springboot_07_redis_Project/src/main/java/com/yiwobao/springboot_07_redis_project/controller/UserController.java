package com.yiwobao.springboot_07_redis_project.controller;

import com.yiwobao.springboot_07_redis_project.dao.UserDao;
import com.yiwobao.springboot_07_redis_project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    UserDao  userDao;

    @PostMapping("/doLogin")
    public  String  login(Model model,String uName,String password){
           User user = userDao.findAllByUserIdAndPassword(uName, password);
            // 将登录信息保存到Redis缓存中,有效时间为expire=50000毫秒
            if(user != null){
                String s = UUID.randomUUID().toString();
                // 设置字符串序列化器，使 key 在 Redis 中以字符串形式显示，否则会出现十六进制代码，不方便查看
                this.redisTemplate.setKeySerializer(new StringRedisSerializer());
                this.redisTemplate.opsForValue().set(s, user, 50000, TimeUnit.MILLISECONDS);
                return s;
            }
        return "账户或者密码错误";

    }

}
