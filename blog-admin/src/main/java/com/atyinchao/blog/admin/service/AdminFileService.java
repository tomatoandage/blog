package com.atyinchao.blog.admin.service;

import com.atyinchao.blog.admin.model.vo.file.UploadFileResponseVO;
import com.atyinchao.blog.common.utils.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author yinchao
 * @Date 2024/12/14
 */
public interface AdminFileService {

    Response<UploadFileResponseVO> uploadFile(MultipartFile file);
}
