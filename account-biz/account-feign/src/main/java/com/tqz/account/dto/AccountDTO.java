package com.tqz.account.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 接口传输层
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:57
 */
public class AccountDTO implements Serializable {
    private Integer id;
    private String accountCode;
    private String accountName;
    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
