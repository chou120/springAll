package com.yiwobao.springboot_11_plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @TableId(type=IdType.AUTO)
    private Long id;
   // @TableField(condition = SqlCondition.LIKE)   // 配置该字段使用like进行拼接
    private String name;

    private Integer age;
    private String email;
    private Long managerId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Version
    private Integer version;
}
