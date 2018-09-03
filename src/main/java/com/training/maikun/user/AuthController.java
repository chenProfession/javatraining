package com.training.maikun.user;

import com.training.maikun.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: order
 * @Description: Anth
 * @author: Mr.Cheng
 * @date: 2018/8/21 上午10:54
 */
@RestController
@RequestMapping(value = "/Auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
    * @Description: login the system
    * @Param: [username, password]
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/8/24 上午1:12
    */ 
    @PostMapping(path = "/login")
    public String getToken(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        return authService.login(username,password);
    }

    @PostMapping(path = "/test")
    public String getHello(@RequestParam("name") String name){
        return name;
    }

    @PostMapping(path = "/register")
    public ResultView register(@RequestBody User user){
        return authService.register(user);
    }
}
