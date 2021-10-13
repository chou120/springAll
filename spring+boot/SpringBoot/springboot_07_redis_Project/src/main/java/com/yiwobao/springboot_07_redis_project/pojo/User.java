package com.yiwobao.springboot_07_redis_project.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private Integer  uid;
    private String uName;
    private String password;
    private String address;
    private Date birthday;
}