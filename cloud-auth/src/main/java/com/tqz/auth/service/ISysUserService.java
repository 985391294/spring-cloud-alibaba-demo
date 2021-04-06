package com.tqz.auth.service;

import com.tqz.auth.po.SysUser;

/**
 * <p>
 * 系统用户的服务接口
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:27
 */
public interface ISysUserService {

    /**
     * 根据用户名查找
     *
     * @param userName 用户名
     * @return
     */
    SysUser selectByUserName(String userName);

    /**
     * 根据手机号码获取用户信息
     *
     * @param mobile 手机号
     * @return
     */
    SysUser getUserByMobile(String mobile);


}
