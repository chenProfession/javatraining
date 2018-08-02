package com.training.maikun.products;

import com.training.maikun.products.view.ProductInfoView;

import java.util.List;

/**
 * @program: order
 * @Description: To get the list of product
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:10
 */

public interface ProductService {

    /**
    * @Description: To get the list of products
    * @Param: []
    * @return: java.util.List<ProductInfo>
    * @Author: Mr.Cheng
    * @Date: 2018/8/1 上午5:15
    */
    List<ProductInfoView> findUpAll();
}
