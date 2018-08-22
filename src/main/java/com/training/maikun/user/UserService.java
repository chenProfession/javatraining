package com.training.maikun.user;

import com.training.maikun.result.ResultView;

/**
 * @program: order
 * @Description: provide the service for the user
 * @author: Mr.Cheng
 * @date: 2018/8/21 下午7:55
 */
public interface UserService {

    /**
    * @Description: find the user information by user name
    * @Param: [username]
    * @return: com.training.maikun.user.User
    * @Author: Mr.Cheng
    * @Date: 2018/8/21 下午7:59
    */ 
    User findUserByName(String username);

    /**
    * @Description: find the user information by user id
    * @Param: [userid]
    * @return: com.training.maikun.user.User
    * @Author: Mr.Cheng
    * @Date: 2018/8/21 下午7:59
    */ 
    User findUserById(String userid);

    /**
    * @Description: user registration
    * @Param: [user]
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/21 下午8:00
    */ 
    ResultView userRegister(User user);

    /**
    * @Description: find the system role by id
    * @Param: [role]
    * @return: com.training.maikun.user.SysRole
    * @Author: Mr.Cheng
    * @Date: 2018/8/21 下午8:03
    */ 
    SysRole findRolebyId(String role);

    /**
    * @Description: add the system role
    * @Param: [sysRole]
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/21 下午8:03
    */ 
    ResultView addSystemRole(SysRole sysRole);
}
