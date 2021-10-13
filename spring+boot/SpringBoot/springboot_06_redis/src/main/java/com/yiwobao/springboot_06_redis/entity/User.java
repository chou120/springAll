package com.yiwobao.springboot_06_redis.entity;


import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long  uid;
    private String uName;
    private String password;
    private String address;
    private Date birthday;
}
