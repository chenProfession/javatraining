package com.training.maikun.util;

import com.training.maikun.products.ProductCategory;
import com.training.maikun.products.ProductInfo;
import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import com.training.maikun.result.ResultView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: order
 * @Description: To make test data
 * @author: Mr.Cheng
 * @date: 2018/8/8 上午1:43
 */
public class DataMaker {

    /**
    * @Description:
    * @Param: []
    * @return: java.util.List<com.training.maikun.products.view.ProductInfoView>
    * @Author: Mr.Cheng
    * @Date: 2018/8/8 上午1:49
    */ 
    public static List<ProductInfoView> makeListOfProductInfoView(){

        ProductInfoView productInfoViewOne = new ProductInfoView();
        ProductInfoView productInfoViewTwo = new ProductInfoView();
        List<ProductInfoView> listProductInfoView = new ArrayList();

        productInfoViewOne.setProductId("0001");
        productInfoViewOne.setProductName("credit card purchase");
        productInfoViewOne.setProductPrice(new BigDecimal(2000.00));
        productInfoViewOne.setProductDescription("This is a good product");
        productInfoViewOne.setProductIcon("sample.jpg");

        productInfoViewTwo.setProductId("0002");
        productInfoViewTwo.setProductName("gold credit card purchase");
        productInfoViewTwo.setProductPrice(new BigDecimal(3000.00));
        productInfoViewTwo.setProductDescription("This is a good product");
        productInfoViewTwo.setProductIcon("sample.jpg");

        listProductInfoView.add(productInfoViewOne);
        listProductInfoView.add(productInfoViewTwo);

        return listProductInfoView;
    }

    public static ProductView makeProductView(){
        return  null;
    }

    public static ProductInfo makeProductInfo(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("Hello");
        productInfo.setProductPrice(new BigDecimal(2000.00));
        productInfo.setProductDescription("this is the best product");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(11);
        productInfo.setCategoryType(0);
        productInfo.setProductStatus(1);
        return  productInfo;
    }

    public static ResultView makeResultViewSuccess(){
        ResultView resultView = new ResultView();
        resultView.setCode(1);
        resultView.setMsg("this is test message");
        resultView.setData("success");
        return resultView;
    }

    public static ResultView makeResultViewFail(){
        ResultView resultView = new ResultView();
        resultView.setCode(2);
        resultView.setMsg("this is test message");
        resultView.setData("error");
        return resultView;
    }

    public static List<ProductCategory> makeProductCategoryList(){
        List<ProductCategory> productCategoryList = new ArrayList();
        ProductCategory productCategoryOne = new ProductCategory();
        productCategoryOne.setProductCategoryId("sample-one");
        productCategoryOne.setProductCategoryName("category-one");
        productCategoryOne.setProductCategoryType(0);

        ProductCategory productCategoryTwo = new ProductCategory();
        productCategoryTwo.setProductCategoryId("sample-two");
        productCategoryTwo.setProductCategoryName("category-two");
        productCategoryTwo.setProductCategoryType(1);

        productCategoryList.add(productCategoryOne);
        productCategoryList.add(productCategoryTwo);

        return productCategoryList;
    }

    public static Map<String,Object> makeProductInfoViewByCategory(){

        Map<String,Object> productByCategoryMap = new HashMap<>();
        ProductInfoView productInfoViewOne = new ProductInfoView();
        ProductInfoView productInfoViewTwo = new ProductInfoView();
        List<ProductInfoView> listProductInfoView = new ArrayList();

        productInfoViewOne.setProductId("0001");
        productInfoViewOne.setProductName("credit card purchase");
        productInfoViewOne.setProductPrice(new BigDecimal(2000.00));
        productInfoViewOne.setProductDescription("This is a good product");
        productInfoViewOne.setProductIcon("sample.jpg");

        productInfoViewTwo.setProductId("0002");
        productInfoViewTwo.setProductName("gold credit card purchase");
        productInfoViewTwo.setProductPrice(new BigDecimal(3000.00));
        productInfoViewTwo.setProductDescription("This is a good product");
        productInfoViewTwo.setProductIcon("sample.jpg");

        listProductInfoView.add(productInfoViewOne);
        listProductInfoView.add(productInfoViewTwo);

        productByCategoryMap.put("sample-one",listProductInfoView);

        ProductInfoView productInfoViewThree = new ProductInfoView();
        ProductInfoView productInfoViewFour = new ProductInfoView();
        List<ProductInfoView> listProductInfoViewNext = new ArrayList();

        productInfoViewThree.setProductId("0001");
        productInfoViewThree.setProductName("credit card purchase");
        productInfoViewThree.setProductPrice(new BigDecimal(2000.00));
        productInfoViewThree.setProductDescription("This is a good product");
        productInfoViewThree.setProductIcon("sample.jpg");

        productInfoViewFour.setProductId("0002");
        productInfoViewFour.setProductName("gold credit card purchase");
        productInfoViewFour.setProductPrice(new BigDecimal(3000.00));
        productInfoViewFour.setProductDescription("This is a good product");
        productInfoViewFour.setProductIcon("sample.jpg");

        listProductInfoViewNext.add(productInfoViewOne);
        listProductInfoViewNext.add(productInfoViewTwo);

        productByCategoryMap.put("sample-two",listProductInfoViewNext);

        return productByCategoryMap;
    }
}