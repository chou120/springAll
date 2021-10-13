package com.yiwobao.springboot_10_exception.dao;

public interface BaseErrorInfoInterface {
    /** 错误码*/

    String getResultCode();

    /** 错误描述*/

    String getResultMsg();
}
