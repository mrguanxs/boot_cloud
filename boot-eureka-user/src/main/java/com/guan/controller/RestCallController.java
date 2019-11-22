package com.guan.controller;

import com.guan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * @author guanxinshuai E-mail:
 * @version 创建时间：2019/11/20 4:19 PM
 * User:
 */
@RestController
@RequestMapping("/rest/call")
public class RestCallController {

    @Autowired
    private RestTemplate restTemplate;

    //服务发现客户端
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Order order(){

        //到eureka server发现order服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("boot-eureka-order");
        //这里只有一个order服务，没有做集群，所以获取第一个，没有做负载均衡
        ServiceInstance serviceInstance = serviceInstances.get(0);

//        Order order = restTemplate.getForObject(serviceInstance.getUri()+ "/order/findById/2", Order.class);
        Order order = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+ "/order/findById/3", Order.class);
        return order;
    }

}