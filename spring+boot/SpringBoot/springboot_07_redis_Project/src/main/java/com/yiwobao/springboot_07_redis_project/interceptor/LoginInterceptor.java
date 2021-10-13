package com.yiwobao.springboot_07_redis_project.interceptor;

import com.yiwobao.springboot_07_redis_project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println("--->"+token);
        User user = (User) redisTemplate.opsForValue().get(token);
        if (user == null){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("请求非法");
            return false;
        }
        return true;


    }
}
