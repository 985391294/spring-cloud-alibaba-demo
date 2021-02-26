package com.tqz.account.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 接口传输层
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:57
 */
@Data
public class AccountDTO implements Serializable {
    private Integer id;
    private String accountCode;
    private String accountName;
    private BigDecimal amount;

}
