package com.yiwobao.springboot_12_plus_gen.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author sanye
 * @since 2021-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Good_ID")
    private String goodId;

    @TableField("Classify_ID")
    private Integer classifyId;

    @TableField("Classify_Description")
    private String classifyDescription;

    @TableField("Good_Brand")
    private String goodBrand;

    @TableField("Good_Name")
    private String goodName;

    @TableField("Good_Price")
    private String goodPrice;

    @TableField("Store_Add")
    private String storeAdd;

    @TableField("Monthsale_Num")
    private Integer monthsaleNum;

    @TableField("Color_Classification")
    private String colorClassification;

    @TableField("Comment_Num")
    private Integer commentNum;

    @TableField("Good_AfterRate")
    private String goodAfterrate;

    @TableField("IndustryCompare")
    private String IndustryCompare;

    @TableField("Good_Link")
    private String goodLink;

    @TableField("Store_Name")
    private String storeName;

    @TableField("Store_Link")
    private String storeLink;

    @TableField("Good_Hot")
    private Integer goodHot;

    @TableField("Store_Age")
    private String storeAge;

    @TableField("Seller_Credit")
    private String sellerCredit;

    @TableField("Ishas_License")
    private Integer ishasLicense;

    @TableField("DescriptionSituation")
    private Double DescriptionSituation;

    @TableField("ServiceAttitude")
    private Double ServiceAttitude;

    @TableField("LogisticsService")
    private Double LogisticsService;

    @TableField("Size")
    private String Size;


}
