package com.yiwobao.pojo;

public class Person {
    private Man man;

    //需要在Person类中增加set
    public void setMan(Man man) {
        this.man = man;
    }

    public Person() {
        System.out.println("byName自动装配是需要提供无参构造器的");
    }

    public Person(Man man) {
        System.out.println("在Person的构造函数内");
        this.man = man;
    }

    public void man() {
        man.show();
    }

}
