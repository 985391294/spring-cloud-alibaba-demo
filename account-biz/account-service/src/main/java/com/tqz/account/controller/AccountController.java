package com.tqz.account.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tqz.account.dto.AccountDTO;
import com.tqz.account.service.AccountService;
import com.tqz.common.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 * account接口
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/24 14:07
 */
@Api(tags = "account接口")
@Log4j2
@RestController
@RequestMapping("account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    public final AccountService accountService;

    @PostMapping("/insert")
    public ResultData<String> insert(@RequestBody AccountDTO accountDTO) {
        log.info("insert account:{}", accountDTO);
        accountService.insertAccount(accountDTO);
        return ResultData.success("insert account succeed");
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete")
    public ResultData<String> delete(@RequestParam String accountCode) {
        log.info("delete account,accountCode is {}", accountCode);
        accountService.deleteAccount(accountCode);
        return ResultData.success("delete account succeed");
    }

    @PostMapping("/update")
    public ResultData<String> update(@RequestBody AccountDTO accountDTO) {
        log.info("update account:{}", accountDTO);
        accountService.updateAccount(accountDTO);
        return ResultData.success("update account succeed");
    }

    @ApiOperation("select接口")
    @GetMapping("/getByCode")
    @SentinelResource(value = "getByCode", blockHandler = "handleException")
//    @PreAuthorize("hasPrivilege('queryAccount')")
    public ResultData getByCode(@RequestParam(required = false) String accountCode) {
        log.warn("get account detail,accountCode is :{}", accountCode);

//        SecurityUser securityUser = SecurityUtils.getUser();
//        log.info(securityUser);

        AccountDTO accountDTO = accountService.selectByCode(accountCode);
        return ResultData.success(accountDTO);
    }

    @PostMapping("/reduce")
    public ResultData<String> reduce(@RequestParam("accountCode") String accountCode, @RequestParam("amount") BigDecimal amount) {
        log.info("reduce account amount, accountCode is :{},amount is {} ", accountCode, amount);
        return accountService.reduceAccount(accountCode, amount);
    }

    /**
     * 自定义异常策略
     * 返回值和参数要跟目标函数一样，参数可以追加BlockException
     */
    public ResultData<AccountDTO> handleException(String accountCode, BlockException exception) {
        log.info("flow exception{}", exception.getClass().getCanonicalName());
        return ResultData.fail(900, "达到阈值了,不要再访问了!");
    }

}
