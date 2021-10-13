package com.yiwobao.pojo;

public class Phone {
    private String operator;
    private String phoneNumber;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "operator='" + operator + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
