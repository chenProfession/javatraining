package com.training.maikun.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @program: order
 * @Description: Role of application
 * @author: Mr.Cheng
 * @date: 2018/8/12 下午8:18
 */
@Data
@Entity
@Table(name = "user_role")
@DynamicUpdate
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysRole {

    @Id
    @Column(name = "id")
    private Integer roleId;

    @Column(nullable = false)
    private String roleName;
}
