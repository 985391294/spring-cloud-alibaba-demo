package com.tqz.product;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 * product-service启动类
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/25 10:15
 */
@SpringCloudApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
