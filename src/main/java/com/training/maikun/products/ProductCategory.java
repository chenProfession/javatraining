package com.training.maikun.products;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: order
 * @Description: The category of the product
 * @author: Mr.Cheng
 * @date: 2018/8/4 上午12:42
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class ProductCategory {

    /** product category id **/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** product category Name **/
    private String productCategoryName;

    /** product category type code **/
    private Integer productCategoryType;

    /** the create time **/
    @CreatedDate
    private Date createTime;

    /** the modify time **/
    @LastModifiedDate
    private Date updateTime;
}
