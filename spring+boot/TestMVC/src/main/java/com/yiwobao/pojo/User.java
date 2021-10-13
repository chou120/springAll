package com.yiwobao.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class User {
    private Integer uid;
    private String username;
    private Integer age;

    private List<Address> address;//这里使用List集合接收表单多个地址信息

    //用来测试自定义类型转换
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public List<Address> getAddress() {
        return address;
    }
    public void setAddress(List<Address> address) {
        this.address = address;
    }
    /*private Address address;
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }*/


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
