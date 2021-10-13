package com.yiwobao.pojo;

public class Man {
    private String name;
    private int age;
    public Man() {
        System.out.println("在man的构造函数内");
    }
    public Man(String name, int age) {
        System.out.println("在man的有参构造函数内");
        this.name = name;
        this.age = age;
    }
    public void show() {
        System.out.println("名称：" + name + "\n年龄：" + age);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
