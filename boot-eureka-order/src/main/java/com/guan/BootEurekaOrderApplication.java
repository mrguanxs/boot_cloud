package com.guan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient		//开启eureka client
@SpringBootApplication
public class BootEurekaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEurekaOrderApplication.class, args);
	}

}
