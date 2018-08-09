package com.training.maikun.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.maikun.result.ResultService;
import com.training.maikun.util.DataMaker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@Slf4j
public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private ResultService resultService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getListSuccess() throws Exception {

        given(productService.getTopTenProducts()).willReturn(10);
        given(resultService.getResultViewProductSuccess()).willReturn(DataMaker.makeResultViewSuccess());

        String result = this.mvc.perform(get("/buyer/product/list"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

    @Test
    public void getListFail() throws Exception {
        given(resultService.getResultViewProductFail()).willReturn(DataMaker.makeResultViewFail());

        String result = this.mvc.perform(get("/buyer/product/list"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result);

    }

    @Test
    public void insertProductSuccess() throws Exception {
        given(productService.insertProductInfo(any(ProductInfo.class))).willReturn(DataMaker.makeResultViewSuccess());

        ObjectMapper mapper = new ObjectMapper();
        String result = this.mvc.perform(post("/buyer/product/insert")
                                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                                        .content(mapper.writeValueAsString(DataMaker.makeProductInfo())))
                                .andExpect(status().isOk())
                                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

    @Test
    public void insertProductFailed() throws Exception {
    }

    @Test
    public void getProductInfo() throws Exception {

        given(productService.getProductInfo(anyString())).willReturn(DataMaker.makeProductInfo());

        String result = this.mvc.perform(get("/buyer/product/get-product-info")
                          .param("productId","number-one"))
                          .andExpect(status().isOk())
                          .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

}