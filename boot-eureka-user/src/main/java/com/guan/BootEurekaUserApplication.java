package com.guan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient		//开启eureka client
@SpringBootApplication
public class BootEurekaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEurekaUserApplication.class, args);
	}

	/**
	 * 使用RestTemplate进行服务调用
	 * RestTemplate是Spring对Http的一个封装类，提供rest风格的远程调用
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
