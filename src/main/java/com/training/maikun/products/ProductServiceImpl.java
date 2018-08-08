package com.training.maikun.products;

import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import com.training.maikun.result.ResultView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
     * @Description: To get the View of product Information by category
     * @Param: []
     * @return: java.util.List<com.training.maikun.products.view.ProductInfoView>
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午2:00
     */
    @Override
    public Map<String,Object> getProductInfoViewMapByCategory() {
        return null;
    }

    /**
     * @param productInfo
     * @Description: To insert the details of product
     * @Param: [productInfo]
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 下午4:11
     */
    @Override
    public ResultView insertProductInfo(ProductInfo productInfo) {
        return null;
    }

    /**
     * @param productId
     * @Description:
     * @Param: [productId]
     * @return: com.training.maikun.products.ProductInfo
     * @Author: Mr.Cheng
     * @Date: 2018/8/8 上午10:08
     */
    @Override
    public ProductInfo getProductInfo(String productId) {
        return null;
    }

    /**
     * @Description: To get the category of the prodcut
     * @Param: []
     * @return: com.training.maikun.products.ProductCategory
     * @Author: Mr.Cheng
     * @Date: 2018/8/8 下午8:12
     */
    @Override
    public List<ProductCategory> getProductCategory() {
        return null;
    }

}
