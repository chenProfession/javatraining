package com.training.maikun.order;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: order
 * @Description: the details of order
 * @author: Mr.Cheng
 * @date: 2018/8/14 下午5:19
 */
@Data
@Entity
@DynamicUpdate
public class OrderInfo {

    @Id
    private String orderId;

    /** 订单id. */
    @Column(nullable = false)
    private String orderDetailId;

    /** 商品id. */
    @Column(nullable = false)
    private String productId;

    /** 商品名称. */
    @Column(nullable = false)
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;
}
