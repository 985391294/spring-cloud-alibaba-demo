package com.tqz.account.service.impl;

import com.tqz.account.mapper.AccountMapper;
import com.tqz.account.dto.AccountDTO;
import com.tqz.account.po.Account;
import com.tqz.account.service.AccountService;
import com.tqz.common.base.ResultData;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Result;
import java.math.BigDecimal;

/**
 * <p>
 * Account Service 接口层
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:28
 */
@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Override
    public AccountDTO selectByCode(String accountCode) {
        AccountDTO accountDTO = new AccountDTO();
        Account account = accountMapper.selectByCode(accountCode);
        BeanUtils.copyProperties(account,accountDTO);
        return accountDTO;
    }

    @Override
    public void updateAccount(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO,account);
        accountMapper.updateById(account);
    }

    @Override
    public void insertAccount(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO,account);
        accountMapper.insert(account);
    }

    @Override
    public void deleteAccount(String accountCode) {
        accountMapper.deleteByCode(accountCode);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public ResultData reduceAccount(String accountCode, BigDecimal amount) {
        log.info("Account XID is: {}", RootContext.getXID());
        Account account = accountMapper.selectByCode(accountCode);
        if(null == account){
            throw new RuntimeException("can't reduce amount,account is null");
        }
        BigDecimal subAmount = account.getAmount().subtract(amount);
        if(subAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("can't reduce amount,account'amount is less than reduce amount");
        }
        account.setAmount(subAmount);
        int result = accountMapper.updateById(account);
        if (result > 0) {
            return ResultData.success("扣减账户余额成功！");
        } else {
            return ResultData.fail("扣减账户余额失败！");
        }
    }
}
