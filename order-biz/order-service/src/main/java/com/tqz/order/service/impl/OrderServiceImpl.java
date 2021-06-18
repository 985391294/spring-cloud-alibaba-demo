package com.tqz.order.service.impl;

import com.tqz.common.base.ResultData;
import com.tqz.common.base.ReturnCode;
import com.tqz.common.exception.ServiceException;
import com.tqz.order.dto.OrderDTO;
import com.tqz.order.mapper.OrderMapper;
import com.tqz.order.mapper.RocketMqTransactionLogMapper;
import com.tqz.order.po.Order;
import com.tqz.order.po.RocketmqTransactionLog;
import com.tqz.order.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 订单的服务实现类
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 10:01
 */
@Service
@Log4j2
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
//    private final RocketMQTemplate rocketMQTemplate;
    private final RocketMqTransactionLogMapper rocketMqTransactionLogMapper;
    private final RestTemplate restTemplate;

    @Value("${service.name.account}")
    private String serviceNameAccount;

    @Value("${service.name.product}")
    private String serviceNameProduct;

    @GlobalTransactional(name = "TX_ORDER_CREATE")
    @Override
    public ResultData createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        // 本地存储Order
        this.saveOrder(order);
        log.info("ORDER XID is: {}", RootContext.getXID());

        // 更改為feign远程调用
        MultiValueMap accountParamsMap = new LinkedMultiValueMap();
        accountParamsMap.add("accountCode", orderDTO.getAccountCode());
        accountParamsMap.add("amount", orderDTO.getAmount());

        MultiValueMap productParamsMap = new LinkedMultiValueMap();
        productParamsMap.add("productCode", orderDTO.getProductCode());
        productParamsMap.add("count", orderDTO.getCount());

        ResultData resultData = restTemplate.postForObject(serviceNameAccount + "account/reduce", accountParamsMap, ResultData.class);
        if (resultData.getCode() == ReturnCode.RC100.getCode()) {
            ResultData rs = restTemplate.postForObject(serviceNameProduct + "product/deduct", productParamsMap, ResultData.class);
            if (rs.getCode() == ReturnCode.RC100.getCode()) {
                return ResultData.success("下单成功！");
            }
        }
        throw new ServiceException("下单失败！");
    }


    @Transactional(rollbackFor = RuntimeException.class)
    void saveOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public OrderDTO selectByNo(String orderNo) {
        OrderDTO orderDTO = new OrderDTO();
        Order order = orderMapper.selectByNo(orderNo);
        BeanUtils.copyProperties(order,orderDTO);
        return orderDTO;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void changeStatus(Integer id, String status) {
        orderMapper.changeStatus(id,status);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void changeStatuswithRocketMqLog(Integer id,String status,String transactionId){
        orderMapper.changeStatus(id,status);
        rocketMqTransactionLogMapper.insert(
                RocketmqTransactionLog.builder()
                        .transactionId(transactionId)
                        .log("执行删除订单操作")
                .build()
        );
    }

    @Override
    public void delete(String orderNo) {
        Order order = orderMapper.selectByNo(orderNo);
        //如果订单存在且状态为有效，进行业务处理
   /*     if (order != null && Constant.VALID_STATUS.equals(order.getStatus())) {
            String transactionId = UUID.randomUUID().toString();
            //如果可以删除订单则发送消息给rocketmq，让用户中心消费消息

            rocketMQTemplate.sendMessageInTransaction("add-amount",
                    MessageBuilder.withPayload(
                            UserAddMoneyDTO.builder()
                                    .userCode(order.getAccountCode())
                                    .amount(order.getAmount())
                                    .build()
                    )
                    .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                    .setHeader("order_id",order.getId())
                    .build()
                    ,order
            );

//            changeStatus(order.getId(), CloudConstant.INVALID_STATUS);
        }*/
    }
}
