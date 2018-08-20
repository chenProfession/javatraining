package com.training.maikun.products.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: order
 * @Description: The View of product - buyer
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午4:44
 */
@Data
public class ProductView {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("financeProducts")
    private List<ProductInfoView> productInfoViewList;

}
