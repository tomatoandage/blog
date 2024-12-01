package com.atyinchao.blog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/2
 */
@Configuration
@MapperScan("com.atyinchao.blog.common.domain.mapper")
public class MybatisPlusConfig {
}
