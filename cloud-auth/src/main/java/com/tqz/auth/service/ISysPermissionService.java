package com.tqz.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tqz.auth.po.SysPermission;

import java.util.List;

/**
 * <p>
 * 系统权限的服务接口
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:28
 */
public interface ISysPermissionService extends IService<SysPermission> {

    /**
     * 获取所有角色的权限
     * @author jianzhang11
     * @date 2020/8/5 12:46
     * @param roleIds 角色id列表
     * @return List<SysPermission>
     */
    List<SysPermission> listPermissionsByRoles(List<Integer> roleIds);
}
