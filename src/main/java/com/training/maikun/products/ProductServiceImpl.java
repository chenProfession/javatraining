package com.training.maikun.products;

import com.training.maikun.products.view.ProductInfoView;
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
    public List<ProductInfoView> findUpAll() {
        return null;
    }
}
