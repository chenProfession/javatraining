package com.training.maikun.products;

//import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;

import com.training.maikun.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;

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
    private ProductService productService;

    @GetMapping(path = "/list")
    public ResultView getList() {
        /* 1. retrieve all the product */

        /* 2. retrieve categories of the product */

        /* 3. make the data */


        /* this is just for testing purpose */
        ResultView resultView = new ResultView();
        ProductView productView = new ProductView();

        productView.setCategoryName("Week in Search");
        productView.setCategoryType(1);
        productView.setProductInfoViewList(productService.findUpAll());

        resultView.setCode(0);
        resultView.setMsg("Success");
        resultView.setData(productView);
        return resultView;

//      *************************************************************
//        ResultView resultView = new ResultView();
//        ProductView productView = new ProductView();
//        ProductInfoView productInfoViewOne = new ProductInfoView();
//        ProductInfoView productInfoViewTwo = new ProductInfoView();
//        List<ProductInfoView> listProductView = new ArrayList();
//
//        productInfoViewOne.setProductId("0001");
//        productInfoViewOne.setProductName("credit card purchase");
//        productInfoViewOne.setProductPrice(new BigDecimal(2000.00));
//        productInfoViewOne.setProductDescription("This is a good product");
//        productInfoViewOne.setProductIcon("sample.jpg");
//
//        productInfoViewTwo.setProductId("0002");
//        productInfoViewTwo.setProductName("gold credit card purchase");
//        productInfoViewTwo.setProductPrice(new BigDecimal(3000.00));
//        productInfoViewTwo.setProductDescription("This is a good product");
//        productInfoViewTwo.setProductIcon("sample.jpg");
//
//        listProductView.add(productInfoViewOne);
//        listProductView.add(productInfoViewTwo);
//
//        productView.setCategoryName("Week in Search");
//        productView.setCategoryType(1);
//        productView.setProductInfoViewList(listProductView);
//
//        resultView.setCode(0);
//        resultView.setMsg("Success");
//        resultView.setData(productView);
//
//        return resultView;
    }
}
