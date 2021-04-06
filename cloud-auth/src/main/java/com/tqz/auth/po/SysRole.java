package com.tqz.auth.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 角色
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:24
 */
@Data
@TableName("sys_role")
public class SysRole {

    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id;
    private String roleCode;
    private String roleName;

    @TableField(exist = false)
    private List<SysRole> authorities;
}
