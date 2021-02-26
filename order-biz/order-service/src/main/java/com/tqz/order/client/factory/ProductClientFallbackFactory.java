package com.tqz.order.client.factory;

import com.tqz.order.client.ProductClient;
import com.tqz.order.client.fallback.ProductClientFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * ProductClientFallbackFactory
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:58
 */
@Component
public class ProductClientFallbackFactory implements FallbackFactory<ProductClient> {

    @Override
    public ProductClient create(Throwable throwable) {
        ProductClientFallback productClientFallback = new ProductClientFallback();
        productClientFallback.setCause(throwable);
        return productClientFallback;
    }

}
