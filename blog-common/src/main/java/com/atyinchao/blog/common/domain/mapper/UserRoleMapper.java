package com.atyinchao.blog.common.domain.mapper;

import com.atyinchao.blog.common.domain.dos.UserRoleDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @ClassName UserRoleMapper
 * @Description
 * @Date 2024/12/5 20:54
 * @Author yinchao
 **/
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    default List<UserRoleDO> selectByUsername(String username) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername,username);
        return selectList(wrapper);
    }
}
