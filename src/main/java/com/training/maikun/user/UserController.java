package com.training.maikun.user;

import com.training.maikun.result.ResultService;
import com.training.maikun.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: order
 * @Description: To operate user object
 * @author: Mr.Cheng
 * @date: 2018/8/9 上午4:12
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private ResultService resultService;

    /**
    * @Description: user registration
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/9 上午4:18
    */ 
    @PostMapping(path = "/register")
    public ResultView userRegister(@RequestBody User user){
        log.info(user.getUsername());
        return resultService.getResultViewRegisterSuccess();
    }
}
