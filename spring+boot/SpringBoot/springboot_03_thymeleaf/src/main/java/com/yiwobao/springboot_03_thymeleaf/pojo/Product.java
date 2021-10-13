package com.yiwobao.springboot_03_thymeleaf.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class Product implements Serializable {
    private Integer pid;//产品编号
    private String  pName;
    private Double  price;//价格
    private Double  lessPrice;//折扣
    private Date    createDate; //生产日期
    private String  address;//产地
    private Integer  number;//产品数量
}
