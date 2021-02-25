package com.tqz.order.client.factory;

import com.tqz.order.client.AccountClient;
import com.tqz.order.client.fallback.AccountClientFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <code>AccountFeignFallbackFactory</code>
 * </p>
 * Description:
 *
 * @author jianzh5
 * @date 2020/10/13 15:43
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
