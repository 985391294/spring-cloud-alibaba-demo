package com.tqz.auth.service.impl;

import com.tqz.auth.mapper.SysUserMapper;
import com.tqz.auth.po.SysPermission;
import com.tqz.auth.po.SysRole;
import com.tqz.auth.po.SysUser;
import com.tqz.auth.service.ISysPermissionService;
import com.tqz.auth.service.ISysRoleService;
import com.tqz.auth.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
<<<<<<< HEAD
 * 系统用户实现类
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:29
=======
 *
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/3/6 15:22
>>>>>>> origin/master
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysUserServiceImpl implements ISysUserService {

    private final SysUserMapper sysUserMapper;

    private final ISysRoleService sysRoleService;
    private final ISysPermissionService sysPermissionService;

    @Override
<<<<<<< HEAD
    public SysUser selectByUserName(String userName) {
        return sysUserMapper.selectByUserName(userName);
    }

    @Override
=======
>>>>>>> origin/master
    public SysUser getUserByMobile(String mobile) {
        SysUser sysUser = sysUserMapper.selectByMobile(mobile);
        if(sysUser != null) {
            //获取当前用户的所有角色
            List<SysRole> roleList = sysRoleService.listRolesByUserId(sysUser.getId());
            sysUser.setRoles(roleList.stream().map(SysRole::getRoleCode).collect(Collectors.toList()));
            List<Integer> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toList());
            //获取所有角色的权限
            List<SysPermission> permissionList = sysPermissionService.listPermissionsByRoles(roleIds);

            sysUser.setPermissions(
                    permissionList.stream()
                        .map(SysPermission::getPermission)
                        .collect(Collectors.toList())
            );
        }
        return sysUser;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
