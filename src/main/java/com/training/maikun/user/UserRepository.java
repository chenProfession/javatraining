package com.training.maikun.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: user
 * @Description: Repository
 * @author: Mr.Cheng
 * @date: 2018/8/14 下午5:15
 */
public interface UserRepository extends JpaRepository<User,String> {
    
    /**
    * @Description: find the user by username
    * @Param: [username]
    * @return: com.training.maikun.user.User
    * @Author: Mr.Cheng
    * @Date: 2018/8/21 下午8:37
    */ 
    User findByUsername(String username);

}
