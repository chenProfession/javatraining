package com.training.maikun.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: order
 * @Description: The View of product - buyer
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午4:44
 */

public class ProductView {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoView> productInfoViewList;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public void setProductInfoVOList(List<ProductInfoView> productInfoViewList) {
        this.productInfoViewList = productInfoViewList;
    }
}
