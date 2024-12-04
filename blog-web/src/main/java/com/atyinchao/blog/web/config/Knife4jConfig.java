package com.atyinchao.blog.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Knife4jConfig
 * @Description
 * @Date 2024/12/4 17:07
 * @Author yinchao
 **/
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BLOG 接口文档")
                        .description("blog 接口服务")
                        .version("v1.0.0")
                        .contact(new Contact().name("yinchao").email("3219815800@qq.com").url("http://127.0.0.1:8080"))
                );
    }
}
