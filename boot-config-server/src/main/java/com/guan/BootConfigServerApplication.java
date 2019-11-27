package com.guan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer		//开启配置中心服务
@EnableEurekaClient
@SpringBootApplication
public class BootConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootConfigServerApplication.class, args);
	}

}
