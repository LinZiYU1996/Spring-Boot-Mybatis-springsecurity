package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@MapperScan("com.example.demo.mapper")
public class SafeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeDemoApplication.class, args);
	}

}

