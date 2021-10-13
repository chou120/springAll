package com.yiwobao.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PersonValidate {
    private Integer id;
    @NotNull
    @Pattern(regexp = "^([a-zA-Z]*[0-9_-]*$)", message = "只能包含字母、数字、下划线，且不能以数字或下划线开头")
    @Length(min = 2, max = 8, message = "用户名不能少于2位大于8位")
    private String name;
    @Email(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "邮箱格式不正确")
    private String email;
    @NotNull
    @Range(min=0, max=150,message="年龄不在合法范围内")
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
