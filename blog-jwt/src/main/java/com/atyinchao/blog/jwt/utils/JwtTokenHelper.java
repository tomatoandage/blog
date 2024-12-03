package com.atyinchao.blog.jwt.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

/**
 * @ClassName JwtTokenHelper
 * @Description
 * @Date 2024/12/2 15:10
 * @Author yinchao
 **/
@Component
public class JwtTokenHelper implements InitializingBean {

    /**
     * 签发人
     */
    @Value("${jwt.issuer")
    private String issuer;

    /**
     * 密钥
     */
    private SecretKey key;

    /**
     * JWT解析
     */
    private JwtParser jwtParser;

    /**
     * 解码配置文件中配置的 Base 64 编码 key 为秘钥
     * @param base64Key
     */
    @Value("${jwt.secret}")
    public void setBase64Key(String base64Key) {
        key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(base64Key));
    }

    /**
     * 初始化 JwtParser
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 考虑到不同服务器之间可能存在时钟偏移，setAllowedClockSkewSeconds 用于设置能够容忍的最大的时钟误差
        jwtParser = Jwts.parser()
                .requireIssuer(issuer)
                .verifyWith(key)
                .clockSkewSeconds(10)
                .build();
    }

    /**
     * 生成 Token
     * @param username
     * @return
     */
    public String generateToken(String username) {
        LocalDateTime now = LocalDateTime.now();
        // Token 一个小时后失效
        LocalDateTime expireTime = now.plusHours(1);

        return Jwts.builder().subject(username)
                .issuer(issuer)
                .issuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .expiration(Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key)
                .compact();
    }

    /**
     * 解析 Token
     * @param token
     * @return
     */
    public Jws<Claims> parseToken(String token) {
        try {
            return jwtParser.parseSignedClaims(token);
        } catch (JwtException | IllegalArgumentException e) {
            throw new BadCredentialsException("Token 不可用", e);
        }
    }

    /**
     * 生成一个 Base64 的安全秘钥
     * @return
     */
    private static String generateBase64Key() {
        // 生成安全秘钥
        SecretKey secretKey = Jwts.SIG.HS512.key().build();

        // 将密钥进行 Base64 编码
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        return base64Key;
    }

    /**
     * 校验 Token 是否可用
     * @param token
     * @return
     */
    public void validateToken(String token) {
        jwtParser.parseSignedClaims(token);
    }

    /**
     * 解析 Token 获取用户名
     * @param token
     * @return
     */
    public String getUsernameByToken(String token) {
        try {
            Claims claims = (Claims) jwtParser.parseSignedClaims(token);
            return claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        String key = generateBase64Key();
        System.out.println("key: " + key);
    }
}
