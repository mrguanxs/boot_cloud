package com.guan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy        //开启网关代理功能
public class BootZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootZuulApplication.class, args);
	}

}
