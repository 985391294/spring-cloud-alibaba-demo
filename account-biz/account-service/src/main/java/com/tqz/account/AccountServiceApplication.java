package com.tqz.account;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 * 1.启动Nacos
 *    命令：./startup.sh -m standalone
 * 2.启动Sentinel，
 *    命令：java -jar -Dserver.port=8888 -Dcsp.sentinel.dashboard.server=localhost:8888 -Dproject.name=sentinel-dashboard sentinel-dashboard-1.8.0.jar
 *    -Dsentinel.dashboard.auth.username=sentinel 用于指定控制台的登录用户名为 sentinel；
 *    -Dsentinel.dashboard.auth.password=123456 用于指定控制台的登录密码为 123456；如果省略这两个参数，默认用户和密码均为 sentinel；
 *    -Dserver.servlet.session.timeout=7200 用于指定 Spring Boot 服务端 session 的过期时间，如 7200 表示 7200 秒；60m 表示 60 分钟，默认为 30 分钟；
 * 3.service.vgroupMapping.account_service_seata
 *    linux的seata启动命令： <code>./seata-server.sh -h ip -p 8091 -m db -n 1 >log.out &</code>
 *
 * @author tianqingzhao
 * @since 2021/2/23 10:26
 */
@SpringCloudApplication
//@Endpoint
//@EnableBinding({Sink.class})//接收消息
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
