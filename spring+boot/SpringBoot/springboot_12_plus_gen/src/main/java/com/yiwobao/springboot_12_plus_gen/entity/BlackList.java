package com.yiwobao.springboot_12_plus_gen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class BlackList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long blackUserId;

    private Long userId;


}
