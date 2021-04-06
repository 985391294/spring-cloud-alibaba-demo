package com.tqz.auth.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 权限
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:24
 */
@Data
@TableName("sys_permission")
public class SysPermission {

    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String permission;
    private String url;
}
