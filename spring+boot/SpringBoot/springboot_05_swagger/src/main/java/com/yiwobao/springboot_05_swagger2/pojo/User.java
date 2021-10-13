package com.yiwobao.springboot_05_swagger2.pojo;

import io.swagger.models.auth.In;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    //我们设计接口的时候，往往ID都是Long类型
    private Long id;
    private String name;
    private Integer  age;

}
