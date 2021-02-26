package com.tqz.order.client.factory;

import com.tqz.order.client.AccountClient;
import com.tqz.order.client.fallback.AccountClientFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * AccountFeignFallbackFactory
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:58
 */
@Component
public class AccountClientFallbackFactory implements FallbackFactory<AccountClient> {

    @Override
    public AccountClient create(Throwable throwable) {
        AccountClientFallback accountClientFallback = new AccountClientFallback();
        accountClientFallback.setCause(throwable);
        return accountClientFallback;
    }

}
