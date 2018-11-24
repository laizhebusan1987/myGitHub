package com.cdy.common.rbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cdy.common.rbac.mapper")
@SpringBootApplication
public class RBACApplication {

	public static void main(String[] args) {
		SpringApplication.run(RBACApplication.class, args);
	}
}
