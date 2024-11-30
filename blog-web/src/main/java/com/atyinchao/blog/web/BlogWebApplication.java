package com.atyinchao.blog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.atyinchao.blog.*"})
public class BlogWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogWebApplication.class, args);
	}

}
