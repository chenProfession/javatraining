package com.training.maikun.products;

import com.training.maikun.result.ResultView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @program: order
 * @Description: To show buyer the list of product
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:10
 */
@RestController
@RequestMapping("/buyer/product")
public class ProductController {

    @GetMapping("/list")
    public ResultView getList(){
        /* 1. retrieve all the product */

        /* 2. retrieve categories of the product */

        /* 3. make the data */

        ResultView resultView = new ResultView();
        ProductView productView = new ProductView();
        ProductInfoView productInfoView = new ProductInfoView();

        productView.setCategoryName("Week in Search");
        productView.setCategoryType(1);
        //productView.setProductInfoVOList();

        resultView.setCode(0);
        resultView.setMsg("Success");
        resultView.setData(productView);



        return resultView;
    }
}
