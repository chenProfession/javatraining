package com.training.maikun.products;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception {
    }

    @Test
    public void getTopTenProducts() throws Exception {
        int count = productService.getTopTenProducts();
        log.info("the number is {}",count);
        Assert.assertNotNull(count);
    }

    @Test
    public void getProductViewList() throws Exception {
    }

    @Test
    public void getProductInfoViewMapByCategory() throws Exception {
        Map<Integer,Object> productInfoViewMapByCategory = productService.getProductInfoViewMapByCategory();
        //System.out.println(productInfoViewMapByCategory);
        Assert.assertNotNull(productInfoViewMapByCategory);
    }

    @Test
    public void insertProductInfo() throws Exception {
    }

    @Test
    public void getProductInfo() throws Exception {
    }

    @Test
    public void getProductCategory() throws Exception {
    }

}