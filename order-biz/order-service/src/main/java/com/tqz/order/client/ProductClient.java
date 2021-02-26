package com.tqz.order.client;

import com.tqz.order.client.factory.ProductClientFallbackFactory;
import com.tqz.product.api.ProductFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>
 * ProductClient
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:58
 */
@Component
@FeignClient(name = "product-service",fallbackFactory = ProductClientFallbackFactory.class)
public interface ProductClient extends ProductFeign {
}
