package com.training.maikun.products;

import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: order
 * @Description: implement product service
 * @author: Mr.Cheng
 * @date: 2018/8/2 下午3:53
 */
@Service
public class ProductServiceImpl implements ProductService{

    /**
    * @Description: implement the function of findupall
    * @Param: []
    * @return: java.util.List<com.training.maikun.products.ProductInfo>
    * @Author: Mr.Cheng
    * @Date: 2018/8/2 下午3:54
    */ 
    @Override
    public List<ProductInfo> findUpAll() {
        return null;
    }

    /**
    * @Description: To get the number of products
    * @Param: []
    * @return: java.lang.Integer
    * @Author: Mr.Cheng
    * @Date: 2018/8/7 上午1:34
    */ 
    @Override
    public Integer getNumberOfProducts() {
        return null;
    }

    /**
     * @Description: To get top ten products by ID
     * @Param: []
     * @return: int
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午1:29
     */
    @Override
    public int getTopTenProducts() {
        return 0;
    }

    /**
     * @param productInfoViewList
     * @Description: To get the View of product
     * @Param: []
     * @return: com.training.maikun.products.view.ProductView
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午1:51
     */
    @Override
    public List<ProductView> getProductViewList(List<ProductInfoView> productInfoViewList) {
        return null;
    }

    /**
     * @Description: To get the View of product Information
     * @Param: []
     * @return: java.util.List<com.training.maikun.products.view.ProductInfoView>
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午2:00
     */
    @Override
    public List<ProductInfoView> getProductInfoViewList() {
        return null;
    }

}
