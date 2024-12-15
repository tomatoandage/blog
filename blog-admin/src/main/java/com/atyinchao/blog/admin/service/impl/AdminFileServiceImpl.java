package com.atyinchao.blog.admin.service.impl;

import com.atyinchao.blog.admin.model.vo.file.UploadFileResponseVO;
import com.atyinchao.blog.admin.service.AdminFileService;
import com.atyinchao.blog.admin.utils.MinioUtil;
import com.atyinchao.blog.common.enums.ResponseCodeEnum;
import com.atyinchao.blog.common.exception.BusinessException;
import com.atyinchao.blog.common.utils.Response;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/14
 */
@Service
@Slf4j
public class AdminFileServiceImpl implements AdminFileService {

    @Resource
    private MinioUtil minioUtil;

    @Override
    public Response<UploadFileResponseVO> uploadFile(MultipartFile file) {

        try {
            String url = minioUtil.uploadFile(file);
            return Response.success(UploadFileResponseVO.builder().url(url).build());
        } catch (Exception e) {
            log.error("==> 上传文件至 Minio 错误 ", e);
            throw new BusinessException(ResponseCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
}
