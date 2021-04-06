package com.tqz.account;

import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 * 1.启动Nacos
 * 2.启动Sentinel，
 *      命令：java -jar -Dserver.port=8888 -Dcsp.sentinel.dashboard.server=localhost:8888 -Dproject.name=sentinel-dashboard sentinel-dashboard-1.8.0.jar
 *
 *  service.vgroupMapping.account_service_seata
 *
 * @author tianqingzhao
 * @since 2021/2/23 10:26
 */
@SpringCloudApplication
//@EnableBinding({Sink.class})//接收消息
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
