package com.imooc.testjava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.imooc.testjava.dataobject.mapper") //配置mapper的路径
public class TestJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJavaApplication.class, args);
	}

}
