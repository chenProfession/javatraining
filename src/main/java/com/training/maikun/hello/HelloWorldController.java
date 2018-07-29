package com.training.maikun.hello;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: order
 * @Description: Say hello to test program
 * @Comments: REST API用URI（Uniform Resource Identifiers ）来表示资源
 * @author: Mr.Cheng
 * @date: 2018/7/29 上午12:50
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private final String TEST_WORDS = "Demo for Restful Web Service, welcome %s!";

    /**
    * @Description: 如果 @RequestMapping 没有method属性，则接收任意类型的URL请求。
    * @Param: []
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 上午1:16
    */
    @GetMapping(path = "/sayhello")
    public String sayHello(){
        return String.format(TEST_WORDS,"everyone");
    }

    /**
    * @Description: URI variables
    * @Param: [name]
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 下午12:03
    */ 
    @GetMapping(path = "/sayhello/{name}")
    public String sayHelloWithURI(@PathVariable String name){
        return String.format(TEST_WORDS, name);
    }

    /**
    * @Description: bind query parameters to a method
    * @Param: [name]
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 下午1:18
    */
    @GetMapping(path = "/sayhello/person")
    public String sayHelloWithParam(@RequestParam(value = "name",defaultValue = "lila") String name){
        return String.format(TEST_WORDS, name);
    }

    /**
     * @Description: test Consumable Media Types
     * @Comment: curl -H 'content-type: application/json'
     * @Param: [name]
     * @return: java.lang.String
     * @Author: Mr.Cheng
     * @Date: 2018/7/29 2:16
     */
    @PostMapping(path = "/sayhello/consume",consumes = "application/json")
    public String sayHelloConsumes(@RequestBody String name){
        return String.format(TEST_WORDS, name);
    }

    /**
    * @Description: test the Accept request header and the list of content types
    * @Param: [name]
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 下午2:26
    */ 
    @GetMapping(path = "/sayhello/produces/{name}",produces = "application/json;charset=UTF-8")
    public String sayHelloProduces(@PathVariable String name){
        if(StringUtils.isEmpty(name)){
            name = "Producer";
        }
        return String.format(TEST_WORDS, name);
    }
}
