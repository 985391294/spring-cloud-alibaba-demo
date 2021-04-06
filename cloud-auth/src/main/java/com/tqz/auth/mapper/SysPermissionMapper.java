package com.tqz.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqz.auth.po.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * {@link SysPermission} Dao层
 *
 * @author tianqingzhao
 * @since 2021/4/6 10:25
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 查找角色对应的资源
     *
     * @param roleIds 角色ids
     * @return 资源列表
     */
    List<SysPermission> listPermissionsByRoles(@Param("roleIds") List<Integer> roleIds);
}
