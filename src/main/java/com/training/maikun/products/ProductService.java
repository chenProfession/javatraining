package com.training.maikun.products;

import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import com.training.maikun.result.ResultView;

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

    /**
    * @Description: To insert the details of product
    * @Param: [productInfo]
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/7 下午4:11
    */ 
    ResultView insertProductInfo(ProductInfo productInfo);

    /**
    * @Description:
    * @Param: [productId]
    * @return: com.training.maikun.products.ProductInfo
    * @Author: Mr.Cheng
    * @Date: 2018/8/8 下午2:23
    */ 
    ProductInfo getProductInfo(String productId);
}
