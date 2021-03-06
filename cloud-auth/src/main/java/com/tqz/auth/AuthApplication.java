package com.tqz.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 * Oauth2安全校验模块启动类
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/3/3 17:32
 */
@SpringCloudApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
