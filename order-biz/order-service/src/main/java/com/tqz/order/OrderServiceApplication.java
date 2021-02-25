package com.tqz.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <code>OrderServiceApplication</code>
 * </p>
 * @author JAVA日知录   git clone git://github.com/fengjiachun/Jupiter.git
 * Description:
 * 订单服务启动类
 */
@SpringBootApplication/*(scanBasePackages = {"com.javadaily.product","com.javadaily.order"})*/
@EnableDiscoveryClient
@EnableFeignClients/*(basePackages = "com.javadaily.account.*")*/
//@EnableBinding({Source.class}) //发送消息
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
