package com.training.maikun.products.view;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: order
 * @Description: To show buyer the details of the product
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午4:54
 */
@Data
public class ProductInfoView {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
