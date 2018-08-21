package com.training.maikun.products;

import com.training.maikun.result.ResultService;
import com.training.maikun.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: order
 * @Description: To show buyer the list of product
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:10
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ResultService resultService;

    /**
    * @Description: To get the list of products
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/8 下午4:39
    */ 
    @GetMapping("/list")
    public ResultView getList(HttpServletResponse response) {
        /* 1. retrieve all the product */
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(productService.getTopTenProducts() > 0){
            log.info("success");
            return resultService.getResultViewProductSuccess();
        }
        return resultService.getResultViewProductFail();
    }

    /**
    * @Description: insert the product information
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/7 下午4:09
    */ 
    @PostMapping(path = "/insert")
    public ResultView insertProduct(@RequestBody ProductInfo productInfo,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.insertProductInfo(productInfo);
    }

    /**
    * @Description: to get the product information
    * @Param: [productId]
    * @return: com.training.maikun.products.ProductInfo
    * @Author: Mr.Cheng
    * @Date: 2018/8/8 下午4:40
    */ 
    @GetMapping(path = "/get-product-info")
    public ProductInfo getProductInfo(@RequestParam(value = "productId",defaultValue = "number-one") String productId,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.getProductInfo(productId);
    }
}
