package com.training.maikun.products;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: order
 * @Description: POJO of product - product details
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:16
 */
@Data
@Entity
public class ProductInfo {

    private String productId;

    /** product name */
    private String productName;

    /** product price */
    private BigDecimal productPrice;

    /** stock */
    private Integer productStock;

    /** description */
    private String productDescription;

    /** icon */
    private String productIcon;

    /** status, 0 normal , 1 Out Of Stock */
    private Integer productStatus;

    /** category type id */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
