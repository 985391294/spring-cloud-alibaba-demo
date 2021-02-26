package com.tqz.order.service;

import com.tqz.order.dto.OrderDTO;
import com.tqz.common.base.ResultData;

/**
 * <p>
 * OrderService
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 10:01
 */
public interface OrderService {

    /**
     * 下单接口
     *
     * @param orderDTO
     * @return
     */
    ResultData createOrder(OrderDTO orderDTO);

    /**
     * 根据订单编号查询订单
     *
     * @param orderNo
     * @return
     */
    OrderDTO selectByNo(String orderNo);

    /**
     * 根据id改变状态
     *
     * @param id
     * @param status
     */
    void changeStatus(Integer id, String status);

    /**
     * 根据订单编码删除订单
     *
     * @param orderNo
     */
    void delete(String orderNo);

    void changeStatuswithRocketMqLog(Integer id, String status, String transactionId);


}
