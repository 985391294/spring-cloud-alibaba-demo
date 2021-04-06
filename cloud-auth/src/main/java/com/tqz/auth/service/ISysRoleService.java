package com.tqz.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tqz.auth.po.SysRole;

import java.util.List;

/**
 * <p>
 * 系统角色的服务接口
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:27
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 根据用户id获取所有角色列表
     *
     * @param userId 用户id
     * @return roleList
     */
    List<SysRole> listRolesByUserId(Integer userId);
}
