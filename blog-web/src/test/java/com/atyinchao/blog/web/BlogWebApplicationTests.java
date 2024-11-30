package com.atyinchao.blog.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BlogWebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testLog(){
		log.info("这是一行 Info 级别日志");
		log.warn("这是一行 Warn 级别日志");
		log.error("这是一行 Error 级别日志");

		// 占位符
		String author = "yinchao";
		log.info("这是一行带有占位符日志，作者：{}", author);
	}

}
