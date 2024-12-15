package com.atyinchao.blog.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/14
 */
@ConfigurationProperties(prefix = "minio")
@Component
@Data
public class MinioProperties {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
