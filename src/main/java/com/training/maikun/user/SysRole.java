package com.training.maikun.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: order
 * @Description: Role of application
 * @author: Mr.Cheng
 * @date: 2018/8/12 下午8:18
 */
@Data

@Table(name = "user_role")
@DynamicUpdate
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysRole {

    @Id
    private String roleId;

    @Column(nullable = false)
    private String roleName;
}
