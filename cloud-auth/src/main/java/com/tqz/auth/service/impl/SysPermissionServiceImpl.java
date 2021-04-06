package com.tqz.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqz.auth.mapper.SysPermissionMapper;
import com.tqz.auth.po.SysPermission;
import com.tqz.auth.service.ISysPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统权限实现类
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:30
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Override
    public List<SysPermission> listPermissionsByRoles(List<Integer> roleIds) {
        return baseMapper.listPermissionsByRoles(roleIds);
    }
}
