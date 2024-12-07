package com.atyinchao.blog.jwt.service;

import com.atyinchao.blog.common.domain.dos.UserDO;
import com.atyinchao.blog.common.domain.dos.UserRoleDO;
import com.atyinchao.blog.common.domain.mapper.UserMapper;
import com.atyinchao.blog.common.domain.mapper.UserRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/2
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 判断用户是否存在
        UserDO userDO = userMapper.selectOne(new QueryWrapper<UserDO>().eq("username", username));
        if (Objects.isNull(userDO)) {
            throw new UsernameNotFoundException("该用户不存在");
        }

        //用户角色
        List<UserRoleDO> roleDOList = userRoleMapper.selectByUsername(username);

        String[] roleArr = null;

        //转数组
        if (!CollectionUtils.isEmpty(roleDOList)) {
            List<String> roles = roleDOList.stream().map(p -> p.getRole()).collect(Collectors.toList());
            roleArr = roles.toArray(new String[roleDOList.size()]);
        }

        // 暂时先写死，密码为 quanxiaoha, 这里填写的密文，数据库中也是存储此种格式
        // authorities 用于指定角色，这里写死为 ADMIN 管理员
        return User.withUsername(userDO.getUsername())
                .password(userDO.getPassword())
                .authorities(roleArr)
                .build();
    }
}
