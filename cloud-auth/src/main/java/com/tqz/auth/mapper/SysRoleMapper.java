package com.tqz.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqz.auth.po.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * {@link com.tqz.auth.po.SysRole} Dao层
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:25
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户获取对应的角色列表
     *
     * @param userId 用户id
     * @return List<SysRole>
     */
    List<SysRole> listRolesByUserId(@Param("userId") Integer userId);
}
