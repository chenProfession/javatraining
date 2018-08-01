package com.training.maikun.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)

public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
    * @Description: test sayhello method
    * @Param: []
    * @return: void
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 上午2:35
    */
    @Test
    public void testSayHello() throws Exception {
        this.mvc.perform(get("/hello/sayhello").accept(MediaType.TEXT_PLAIN))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Demo for Restful Web Service, welcome everyone !"));
    }

    /**
    * @Description: test sayhello with URI variables
    * @Param: []
    * @return: void
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 下午12:00
    */
    @Test
    public void testSayHelloWithURIVariables() throws Exception{
        this.mvc.perform(get("/hello/sayhello/Hero").accept(MediaType.TEXT_PLAIN))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Demo for Restful Web Service, welcome Hero !"));

    }
}