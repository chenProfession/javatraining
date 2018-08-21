package com.training.maikun.hello;

import com.training.maikun.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: order
 * @Description: Say hello to test program
 * @Comments: REST API用URI（Uniform Resource Identifiers ）来表示资源
 * @author: Mr.Cheng
 * @date: 2018/7/29 上午12:50
 */
@RestController
@RequestMapping(value = "/hello")
@Slf4j
public class HelloWorldController {

    private final String TEST_WORDS = "Demo for Restful Web Service, welcome %s !";
    private static final String STATUS = "I have written a log file,the level is %s !";

    /**
    * @Description: 如果 @RequestMapping 没有method属性，则接收任意类型的URL请求。
    * @Param: []
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/7/29 上午1:16
    */
    @GetMapping(path = "/sayhello")
    public String sayHello(){
        log.info(String.format(STATUS,"info"));
        log.debug(String.format(STATUS,"debug"));
        log.warn(String.format(STATUS,"warn"));
        log.error(String.format(STATUS,"error"));
        return String.format(TEST_WORDS,"everyone");
    }

    @GetMapping(path = "/sayhi")
    public ResultView sayHi(HttpServletRequest request,HttpServletResponse response){

        HttpSession session = request.getSession(true);
        String sessionId = session.getId();
        session.setAttribute("test",sessionId);

        String origin = request.getHeader("Referer");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addCookie(new Cookie("cookieTest","missYouALot"));

        ResultView resultView = new ResultView();
        resultView.setCode(0);
        resultView.setMsg(String.format(TEST_WORDS,sessionId));

        return resultView;
    }

    @GetMapping(path = "/login")
    public ResultView login(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String sessionValue = "null";
        if (session != null) {
            sessionValue = session.getAttribute("test").toString();
        }
        ResultView resultView = new ResultView();
        resultView.setCode(1);
        resultView.setMsg("login success!" + sessionValue +"-----");

        return resultView;
    }

    @PostMapping(path = "/sayPost")
    public String sayPost(@RequestParam("sayId") String post, HttpServletRequest request, HttpServletResponse response){
        String sessionId = request.getSession(true).getId();
        log.info(sessionId);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return String.format(TEST_WORDS,post);
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

    /**
     * @Description: Write a logg file
     * @Param: []
     * @return: void
     * @Author: Mr.Cheng
     * @Date: 2018/8/1 上午10:15
     */

    @GetMapping(path = "/output")
    public String outputLoggerFile(){
        log.info("Today is very hot!");
        return STATUS;
    }
}
