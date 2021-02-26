package com.tqz.order.client;

import com.tqz.order.client.factory.AccountClientFallbackFactory;
import com.tqz.account.api.AccountApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>
 * AccountClient
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:58
 */
@Component
@FeignClient(name = "account-service",fallbackFactory = AccountClientFallbackFactory.class)
public interface AccountClient extends AccountApi {
}
