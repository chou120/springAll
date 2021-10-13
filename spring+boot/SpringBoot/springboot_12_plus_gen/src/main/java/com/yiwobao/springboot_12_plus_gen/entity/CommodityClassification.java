package com.yiwobao.springboot_12_plus_gen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class CommodityClassification implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Classify_ID", type = IdType.AUTO)
    private Integer classifyId;

    @TableField("Good_kinds_Name")
    private String goodKindsName;

    @TableField("Upper_ID")
    private Integer upperId;

    @TableField("Upper_Name")
    private String upperName;

    @TableField("Description")
    private String Description;


}
