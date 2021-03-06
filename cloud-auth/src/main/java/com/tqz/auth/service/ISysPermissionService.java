package com.tqz.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tqz.auth.po.SysPermission;

import java.util.List;

/**
 * <p>
 * 权限服务接口
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/3/6 15:18
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
