package com.tqz.auth.controller;

import com.tqz.auth.mapper.SysUserMapper;
import com.tqz.auth.po.SysUser;
import com.tqz.auth.service.ISysUserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>
 *
 * </p>
 *
 * @autoor tianqingzhao
 * @since 2021/3/6 15:14
 */
@Api(value = "用户接口")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(Autowired.class))
public class UserController {

    public final ISysUserService sysUserService;

    public final SysUserMapper userMapper;

    @GetMapping("getByName")
    public SysUser getByName(){
        return userMapper.selectByUserName("zhangjian");
    }

    /**
     * 获取授权的用户信息
     * @param principal 当前用户
     * @return 授权信息
     */
    @GetMapping("current/get")
    public Principal user(Principal principal){
        return principal;
    }
}
