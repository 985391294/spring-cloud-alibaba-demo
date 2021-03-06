package com.tqz.auth.service;

import com.tqz.auth.po.SysUser;

/**
 * <p>
 * 用户服务接口
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/3/6 15:19
 */
public interface ISysUserService {

    /**
     * 根据手机号码获取用户信息
     * @author jianzhang11
     * @date 2020/7/23 16:23
     * @param mobile 手机号码
     * @return 用户信息
     */
    SysUser getUserByMobile(String mobile);
}
