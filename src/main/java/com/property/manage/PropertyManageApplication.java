package com.property.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 */
@EnableTransactionManagement
@MapperScan(value = "com.mysql.cj.jdbc.Driver.dao.mapper")
@SpringBootApplication
public class PropertyManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyManageApplication.class, args);
	}

}
