package com.tqz.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * 订单服务启动类
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 10:02
 */
@SpringBootApplication(scanBasePackages = {"com.tqz.order", "com.tqz.common"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.tqz.account", "com.tqz.product"})
//@EnableBinding({Source.class}) //发送消息
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
