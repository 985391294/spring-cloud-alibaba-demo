package com.tqz.account.service;


import com.tqz.account.dto.AccountDTO;
import com.tqz.common.base.ResultData;

import java.math.BigDecimal;

/**
 * <p>
 * Account Service 接口层
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:26
 */
public interface AccountService {

    /**新增用户*/
    void insertAccount(AccountDTO accountDTO);

    /**删除用户*/
    void deleteAccount(String accountCode);

    /**更新用户*/
    void updateAccount(AccountDTO accountDTO);

    /**根据用户编码查找用户详细信息*/
    AccountDTO selectByCode(String accountCode);

    /**扣减账户余额*/
    ResultData reduceAccount(String accountCode, BigDecimal amount);
}
