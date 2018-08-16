package com.training.maikun.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: order
 * @Description: POJO of product - product details
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午5:16
 */
@Data
@Entity
@Table(name = "product_info")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class ProductInfo {

    @Id
    private String productId;

    /** product name */
    @Column(nullable = false)
    private String productName;

    /** product price */
    @Column(nullable = false)
    private BigDecimal productPrice;

    /** stock */
    private Integer productStock;

    /** description */
    private String productDescription;

    /** icon */
    private String productIcon;

    /** status, 0 normal , 1 Out Of Stock */
    private Integer productStatus;

    /** category type id */
    private Integer categoryType;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
