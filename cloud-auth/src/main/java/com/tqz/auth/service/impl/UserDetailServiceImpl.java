package com.tqz.auth.service.impl;

import com.tqz.auth.mapper.SysUserMapper;
import com.tqz.auth.po.SysUser;
import com.tqz.auth.service.ISysPermissionService;
import com.tqz.auth.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义用户实现类
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:29
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 获取本地用户
        SysUser user = sysUserMapper.selectByUserName(userName);
        if (user != null) {
            // 返回oauth2的用户
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    AuthorityUtils.createAuthorityList(user.getRole()));
        } else {
            throw new UsernameNotFoundException("用户[" + userName + "]不存在");
        }
    }

}
