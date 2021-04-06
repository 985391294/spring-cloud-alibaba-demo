package com.tqz.auth.controller;

import com.tqz.auth.po.SysUser;
import com.tqz.auth.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户控制器
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:45
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public ISysUserService sysUserService;

    @ApiOperation(value = "根据用户名查找", notes = "根据用户名查找")
    @GetMapping("getByName")
    public SysUser getByName() {
        return sysUserService.selectByUserName("zhangjian");
    }

    @ApiOperation(value = "获取授权的用户信息", notes = "获取授权的用户信息")
    @GetMapping("current/get")
    public HttpTrace.Principal user(HttpTrace.Principal principal) {
        return principal;
    }
}