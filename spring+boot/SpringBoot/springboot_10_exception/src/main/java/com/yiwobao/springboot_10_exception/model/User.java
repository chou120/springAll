package com.yiwobao.springboot_10_exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /** 编号 */
    private Integer id;
    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;
}
