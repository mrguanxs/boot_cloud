package com.guan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer		//开启eureka server服务
@SpringBootApplication
public class BootEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEurekaServerApplication.class, args);
	}

}
