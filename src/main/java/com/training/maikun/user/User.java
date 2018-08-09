package com.training.maikun.user;

import lombok.Data;

/**
 * @program: order
 * @Description: User login
 * @author: Mr.Cheng
 * @date: 2018/8/9 上午4:08
 */
@Data
public class User {

    /** user unique id **/
    private long id;

    /** user user name **/
    private String username;

    /** user user password **/
    private String password;
}
