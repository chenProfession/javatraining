package com.training.maikun.order;

import org.springframework.stereotype.Service;

/**
 * @program: order
 * @Description: implement OrderService
 * @author: Mr.Cheng
 * @date: 2018/8/15 上午1:00
 */
@Service
public class OrderServiceImpl implements OrderService{
    /**
     * 创建订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDetails create(OrderDetails orderDTO) {
        return null;
    }

    /**
     * 查询单个订单.
     *
     * @param orderId
     */
    @Override
    public OrderDetails findOne(String orderId) {
        return null;
    }

    /**
     * 取消订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDetails cancel(OrderDetails orderDTO) {
        return null;
    }

    /**
     * 完结订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDetails finish(OrderDetails orderDTO) {
        return null;
    }

    /**
     * 支付订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDetails paid(OrderDetails orderDTO) {
        return null;
    }
}
