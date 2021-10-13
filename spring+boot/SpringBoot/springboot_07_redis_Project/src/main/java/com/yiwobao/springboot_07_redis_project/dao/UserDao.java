package com.yiwobao.springboot_07_redis_project.dao;

import com.yiwobao.springboot_07_redis_project.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao{
    @Select("select *from redis_user where uName=#{uName} and password=#{password}")
    User findAllByUserIdAndPassword(@Param("uName") String uName,
                                    @Param("password") String password);
}
