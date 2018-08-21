package com.training.maikun.user;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: order
 * @Description: User Class
 * @author: Mr.Cheng
 * @date: 2018/8/13 上午11:33
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    private String email;

    private Date lastPasswordResetDate;

    private List<String> roles;
}
