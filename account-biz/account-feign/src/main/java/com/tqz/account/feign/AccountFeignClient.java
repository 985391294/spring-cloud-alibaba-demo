package com.tqz.account.feign;

import com.tqz.account.dto.AccountDTO;
import com.tqz.account.fallback.AccountFallbackFactory;
import com.tqz.common.base.Constant;
import com.tqz.common.base.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 * AccountFeign
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:56
 */
@FeignClient(path = "account", name = Constant.ACCOUNT_SERVICE_NAME, fallback = AccountFallbackFactory.class)
public interface AccountFeignClient {

    @PostMapping("/insert")
    ResultData<String> insert(@RequestBody AccountDTO accountDTO);

    @PostMapping("/delete")
    ResultData<String> delete(@RequestParam("accountCode") String accountCode);

    @PostMapping("/update")
    ResultData<String> update(@RequestBody AccountDTO accountDTO);

    @GetMapping("/getByCode")
    ResultData<AccountDTO> getByCode(@RequestParam(value = "accountCode") String accountCode);

    @PostMapping("reduce")
    ResultData<String> reduce(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount);

}
