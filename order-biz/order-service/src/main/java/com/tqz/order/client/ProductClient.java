package com.tqz.order.client;

import com.tqz.order.client.factory.ProductClientFallbackFactory;
import com.tqz.product.api.ProductFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <code>ProductClient</code>
 * </p>
 * Description:
 *
 * @author jianzh5
 * @date 2020/11/30 14:50
 */
@Component
@FeignClient(name = "product-service",fallbackFactory = ProductClientFallbackFactory.class)
public interface ProductClient extends ProductFeign {
}
