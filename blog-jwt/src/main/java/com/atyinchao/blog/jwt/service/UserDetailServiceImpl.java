package com.atyinchao.blog.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/2
 */
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询
        // ...

        // 暂时先写死，密码为 quanxiaoha, 这里填写的密文，数据库中也是存储此种格式
        // authorities 用于指定角色，这里写死为 ADMIN 管理员
        return User.withUsername("yinchao")
                .password("$2a$10$Eje3wr1wsW.Cn/QM0UQxIuRWcxmZb1otif/xlsJnEE45L5yv3gkWq")
                .authorities("ADMIN")
                .build();
    }
}
