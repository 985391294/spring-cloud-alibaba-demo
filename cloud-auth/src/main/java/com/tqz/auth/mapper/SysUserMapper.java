package com.tqz.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqz.auth.po.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * {@link SysUser} Dao层
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:26
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名查找用户
     *
     * @param userName 用户名
     * @return
     */
    SysUser selectByUserName(@Param("userName") String userName);

    /**
     * 根据手机号查找
     *
     * @param mobile 手机号
     * @return
     */
    SysUser selectByMobile(@Param("mobile") String mobile);

}
