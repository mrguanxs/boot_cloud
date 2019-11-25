package com.guan;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients		//开启openfeign服务调用
@EnableEurekaClient		//开启eureka client
@SpringBootApplication
//@EnableHystrix			//ribbbon方式开启熔断功能
public class BootEurekaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEurekaUserApplication.class, args);
	}

//	/**
//	 * 使用RestTemplate进行服务调用
//	 * RestTemplate是Spring对Http的一个封装类，提供rest风格的远程调用
//	 */
//	@Bean
//	@LoadBalanced		//添加ribbon负载均衡组件
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");		//访问地址，用于监控面板
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
