package com.yiwobao.springboot_03_thymeleaf.pojo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    private String nick;
    private String phone;
    private String  address;
    private Date   birthday ;
    private String  email;

}
