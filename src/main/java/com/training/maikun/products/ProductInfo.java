package com.training.maikun.products;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: order
 * @Description: POJO of product - product details
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:16
 */
@Data
public class ProductInfo {
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
