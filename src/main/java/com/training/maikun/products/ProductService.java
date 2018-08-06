package com.training.maikun.products;

import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;

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
    List<ProductInfo> findUpAll();

    /**
    * @Description: To get the number of the products
    * @Param: []
    * @return: java.lang.Integer
    * @Author: Mr.Cheng
    * @Date: 2018/8/4 上午1:28
    */ 
    Integer getNumberOfProducts();

    /**
    * @Description: To get top ten products by ID
    * @Param: []
    * @return: int
    * @Author: Mr.Cheng
    * @Date: 2018/8/7 上午1:29
    */ 
    int getTopTenProducts();

    /**
    * @Description: To get the View of product
    * @Param: []
    * @return: com.training.maikun.products.view.ProductView
    * @Author: Mr.Cheng
    * @Date: 2018/8/7 上午1:51
    */ 
    List<ProductView> getProductViewList(List<ProductInfoView> productInfoViewList);

    /**
    * @Description: To get the View of product Information
    * @Param: []
    * @return: java.util.List<com.training.maikun.products.view.ProductInfoView>
    * @Author: Mr.Cheng
    * @Date: 2018/8/7 上午2:00
    */ 
    List<ProductInfoView> getProductInfoViewList();

}
