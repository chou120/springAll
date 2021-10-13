
package com.yiwobao.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$", message = "密码必须为8~16个字母和数字组合")
    private String password;
    @Email(message = "邮箱不正确")
    private String email;

    private Integer gender;


}
/*
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
public class User {
    @Value("${nickname}")
    private String nickname;
    @Value("${age}")
    private Integer  age;

    @Value("${user.list}")
    private List<String> stringList;
    //1.4 读取Map集合类型
    @Value("#{${user.map}}")
    private Map<String,Object> map;



}
*/

