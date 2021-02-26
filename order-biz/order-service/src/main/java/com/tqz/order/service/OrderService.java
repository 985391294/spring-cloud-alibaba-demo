package com.tqz.order.service;

import com.tqz.order.dto.OrderDTO;

/**
 * <p>
 * OrderService
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/26 10:01
 */
public interface OrderService {
    void createOrder(OrderDTO orderDTO);

    /**
     * 根据订单编号查询订单
     */
    OrderDTO selectByNo(String orderNo);

    /**
     * 根据id改变状态
     */
    void changeStatus(Integer id, String status);

    /**
     * 根据订单编码删除订单
     */
    void delete(String orderNo);

    void changeStatuswithRocketMqLog(Integer id,String status,String transactionId);


}
