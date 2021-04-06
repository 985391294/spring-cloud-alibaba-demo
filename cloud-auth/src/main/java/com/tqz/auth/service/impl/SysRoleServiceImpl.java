package com.tqz.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tqz.auth.mapper.SysRoleMapper;
import com.tqz.auth.po.SysRole;
import com.tqz.auth.service.ISysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统角色实现类
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:29
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<SysRole> listRolesByUserId(Integer userId) {
        return baseMapper.listRolesByUserId(userId);
    }
}
