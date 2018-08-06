package com.training.maikun.products;


import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import com.training.maikun.result.ResultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    private static final String TEST_JSON = "{\"code\":0,\"msg\":\"Success\",\"data\":{\"name\":\"Week in Search\",\"type\":1,\"finance products\":[{\"id\":\"0001\",\"name\":\"credit card purchase\",\"price\":2000,\"description\":\"This is a good product\",\"icon\":\"sample.jpg\"},{\"id\":\"0002\",\"name\":\"gold credit card purchase\",\"price\":3000,\"description\":\"This is a good product\",\"icon\":\"sample.jpg\"}]}}";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getList() throws Exception {
        ProductInfoView productInfoViewOne = new ProductInfoView();
        ProductInfoView productInfoViewTwo = new ProductInfoView();
        List<ProductInfoView> listProductInfoView = new ArrayList();
        List<ProductView> listProductView = new ArrayList();

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

        given(this.productService.getTopTenProducts()).willReturn(10);
        given(this.productService.getProductInfoViewList()).willReturn(listProductInfoView);
        given(this.productService.getProductViewList(listProductInfoView)).willReturn(10);

        this.mvc.perform(get("/buyer/product/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(TEST_JSON));
    }

}