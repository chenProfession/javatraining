package com.training.maikun.products;

import lombok.Data;

import java.util.Date;

/**
 * @program: order
 * @Description: The category of the product
 * @author: Mr.Cheng
 * @date: 2018/8/4 上午12:42
 */
@Data
public class productCategory {

    /** product category id **/
    private String productCategoryId;

    /** product category Name **/
    private String productCategoryName;

    /** product category type code **/
    private Integer productCategoryType;

    /** the create time **/
    private Date createTime;

    /** the modify time **/
    private Date updateTime;
}
