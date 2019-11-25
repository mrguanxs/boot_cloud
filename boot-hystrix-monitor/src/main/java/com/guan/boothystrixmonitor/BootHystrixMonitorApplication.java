package com.guan.boothystrixmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard		//开启Hystrix监控面板
public class BootHystrixMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootHystrixMonitorApplication.class, args);
	}

}
