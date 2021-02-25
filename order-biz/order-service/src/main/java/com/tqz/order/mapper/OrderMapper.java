package com.tqz.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.tqz.order.po.*;

/**
 * Account Dao层
 * @author JAVA日知录
 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 根据订单编码获取订单
     */
    Order selectByNo(@Param("orderNo") String orderNo);

    /**
     * 修改订单状态
     */
    void changeStatus(@Param("id") Integer id, @Param("status") String status);
}
