package com.imooc.testjava;

import com.imooc.testjava.config.WechatAccountConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.imooc.testjava.dataobject.mapper") //配置mapper的路径
@Slf4j
public class TestJavaApplication {

	@Autowired
	private static WechatAccountConfig accountConfig;

	public static void main(String[] args) {
		log.info("{}", accountConfig.toString());
		SpringApplication.run(TestJavaApplication.class, args);
	}

}
