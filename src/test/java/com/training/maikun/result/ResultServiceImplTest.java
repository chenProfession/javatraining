package com.training.maikun.result;

import com.training.maikun.products.ProductService;
import com.training.maikun.util.DataMaker;
//import com.training.maikun.util.ReadFileToString;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ResultServiceImplTest {

    @MockBean
    ProductService productService;

    @Autowired
    ResultService resultService;

    @Test
    public void getResultViewSuccess() throws Exception {

        given(this.productService.getProductCategory()).willReturn(DataMaker.makeProductCategoryList());
        given(this.productService.getProductInfoViewMapByCategory()).willReturn(DataMaker.makeProductInfoViewByCategory());

        ResultView resultView = resultService.getResultViewSuccess();
        JSONObject json = JSONObject.fromObject(resultView);
        //Assert.assertEquals(json.toString(), ReadFileToString.LoadContentByPath("./sample/json.txt"));
        log.info(json.toString());
    }

    @Test
    public void getResultViewFail() throws Exception {
        String msg = "{\"code\":10,\"data\":\"incorrect parameter\",\"msg\":\"Product does not exist\"}";
        ResultServiceImpl resultService = new ResultServiceImpl();
        ResultView resultView = resultService.getResultViewFail();
        JSONObject json = JSONObject.fromObject(resultView);
        Assert.assertEquals(json.toString(),msg);
        log.info(json.toString());
    }

}