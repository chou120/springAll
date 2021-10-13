package com.yiwobao.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
//@ConfigurationProperties(prefix = "user")
@ConfigurationProperties(prefix = "student")
public class Student {
    //1.1 读取基本类型
    private String nickname;
    private Integer age;
    private List<String> list2;
    private Map<String,Object> map2;
    private Dog dog;

}
