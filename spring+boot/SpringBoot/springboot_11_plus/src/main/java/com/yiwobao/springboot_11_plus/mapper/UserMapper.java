package com.yiwobao.springboot_11_plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yiwobao.springboot_11_plus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper  extends BaseMapper<User> {

    //用来测试自定义sql
        @Select("select * from user")
        List<User> selectRaw();



    // SQL中不写WHERE关键字，且固定使用${ew.customSqlSegment}
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> findAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);


    @Select("select * from user ${ew.customSqlSegment}")
    List<User> findByName(@Param(Constants.WRAPPER) Wrapper<User> wrapper);






}
