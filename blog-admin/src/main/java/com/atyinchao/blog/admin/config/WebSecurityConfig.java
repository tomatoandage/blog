package com.atyinchao.blog.admin.config;

import com.atyinchao.blog.jwt.config.JwtAuthenticationSecurityConfig;
import com.atyinchao.blog.jwt.filter.TokenAuthenticationFilter;
import com.atyinchao.blog.jwt.handler.RestAccessDeniedHandler;
import com.atyinchao.blog.jwt.handler.RestAuthenticationEntryPoint;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Date 2024/12/2 10:47
 * @Author yinchao
 **/
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(proxyTargetClass = true)
public class WebSecurityConfig{

    @Resource
    private JwtAuthenticationSecurityConfig jwtAuthenticationSecurityConfig;

    @Resource
    private RestAuthenticationEntryPoint authEntryPoint;
    @Resource
    private RestAccessDeniedHandler deniedHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .with(jwtAuthenticationSecurityConfig,Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**")
                        .authenticated()
                        .anyRequest()
                        .permitAll()
                )
                .httpBasic(basic -> basic.authenticationEntryPoint(authEntryPoint))
                .exceptionHandling(handler -> handler.accessDeniedHandler(deniedHandler))
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
        return httpSecurity.build();
    }

    /**
     * Token 校验过滤器
     * @return
     */
    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }
}
