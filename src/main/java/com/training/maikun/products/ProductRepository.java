package com.training.maikun.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: order
 * @Description: Repository
 * @author: Mr.Cheng
 * @date: 2018/8/14 下午5:15
 */
public interface ProductRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByCategoryType(Integer categoryType);

    ProductInfo findByProductId(String productId);
}
