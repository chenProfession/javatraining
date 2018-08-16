package com.training.maikun.order;

public interface OrderService {
    /** 创建订单. */
    OrderDetails create(OrderDetails orderDTO);

    /** 查询单个订单. */
    OrderDetails findOne(String orderId);

    /** 取消订单. */
    OrderDetails cancel(OrderDetails orderDTO);

    /** 完结订单. */
    OrderDetails finish(OrderDetails orderDTO);

    /** 支付订单. */
    OrderDetails paid(OrderDetails orderDTO);
}
