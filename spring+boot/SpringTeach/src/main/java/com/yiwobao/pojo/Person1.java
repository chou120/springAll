package com.yiwobao.pojo;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Person1 {

    private String name;
    private String address;
    private List<User> list;
    private Set<User> set;
    private Map<String,User> map;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public void setSet(Set<User> set) {
        this.set = set;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }


}
