package com.tqz.order.controller;

import com.tqz.order.dto.OrderDTO;
import com.tqz.order.service.OrderService;
import com.tqz.common.base.ResultData;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * <p>
 * order控制器
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:59
 */
@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class OrderController {
    private final OrderService orderService;


    @PostMapping("/order/create")
    public ResultData<OrderDTO> create(OrderDTO orderDTO){
        log.info("create order:{}",orderDTO);
        orderDTO.setOrderNo(UUID.randomUUID().toString());
        orderDTO.setAmount(orderDTO.getPrice().multiply(new BigDecimal(orderDTO.getCount())));
        return orderService.createOrder(orderDTO);
    }


    /**
     * 根据订单号删除订单
     * @param orderNo 订单编号
     */
    @PostMapping("/order/delete")
    public ResultData<String> delete(@RequestParam String orderNo){
        log.info("delete order id is {}",orderNo);
        orderService.delete(orderNo);
        return ResultData.success("订单删除成功");
    }


}
