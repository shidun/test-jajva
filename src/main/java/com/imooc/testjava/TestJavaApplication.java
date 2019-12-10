package com.imooc.testjava;

import com.imooc.testjava.config.WechatAccountConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.imooc.testjava.dataobject.mapper") //配置mapper的路径
@Slf4j
public class TestJavaApplication {


	public static void main(String[] args) {
//		Thread thread = new Thread(() -> {
//			System.out.println(111);
//			try {
//				Thread.sleep(5000);
//				System.out.println(66666);
//			} catch (Exception e) {
//				System.out.println(111111);
//			}
//		});
//		thread.start();
//		System.out.println(56555);
////		Stack
////		CopyOnWriteArrayList
////		Hashtable
////		StringBuffer
//		String str1 = "abc";
//		String str = "abc";
//		String str2 = new String("abc");
//
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));
//		System.out.println(str == str1);
//
//		System.out.println(Math.round(-1.5));
//		int a = 4;
//		System.out.println("aaaa-" + ((a>4) ? 99.9 : 9));
		SpringApplication.run(TestJavaApplication.class, args);
	}

}
