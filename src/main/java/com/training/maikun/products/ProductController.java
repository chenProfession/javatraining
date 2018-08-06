package com.training.maikun.products;

import com.training.maikun.result.ResultService;
import com.training.maikun.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: order
 * @Description: To show buyer the list of product
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:10
 */
@RestController
@RequestMapping("/buyer/product")
public class ProductController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultView getList() {
        /* 1. retrieve all the product */
        if(productService.getTopTenProducts() > 0){
            return resultService
                    .getResultViewSuccess(productService
                            .getProductViewList(productService
                                    .getProductInfoViewList()));
        }
        return resultService.getResultViewFail();
    }
}
