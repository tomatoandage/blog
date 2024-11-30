package com.atyinchao.blog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description JSON工具类
 * @Author yinchao
 * @Date 2024/11/30
 */
@Slf4j
public class JsonUtil {

    private static final ObjectMapper INSTANCE = new ObjectMapper();

    public static String toJsonString(Object obj){
        try {
            return INSTANCE.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return obj.toString();
        }
    }
}
