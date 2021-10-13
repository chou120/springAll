package com.yiwobao.annotation.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer uid;
    private String  uname;
    private String  password;

    public User() {
    }

    public User(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
