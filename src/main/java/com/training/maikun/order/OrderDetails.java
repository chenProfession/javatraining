package com.training.maikun.order;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: order
 * @Description: the information of the order
 * @author: Mr.Cheng
 * @date: 2018/8/15 上午12:56
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class OrderDetails {

    /** 订单id. */
    @Id
    private String orderDetailId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @CreatedDate
    private Date createTime;

    /** 更新时间. */
    @LastModifiedDate
    private Date updateTime;
}
