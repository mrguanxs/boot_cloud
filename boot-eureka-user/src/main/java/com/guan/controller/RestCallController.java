package com.guan.controller;

import com.guan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    //调用demo
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Order order(){

        //到eureka server发现order服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("boot-eureka-order");
        //这里只有一个order服务，没有做集群，所以获取第一个，没有做负载均衡
        ServiceInstance serviceInstance = serviceInstances.get(0);

        Order order = restTemplate.getForObject(serviceInstance.getUri()+ "/order/findById/2", Order.class);
        return order;
    }


    @Autowired
    private LoadBalancerClient balancerClient;

    //Ribbion负载均衡写法一
    @RequestMapping(value = "/order/balance1", method = RequestMethod.GET)
    public Order orderBalance1(){

        //默认负载均衡算法：轮询
        ServiceInstance serviceInstance = balancerClient.choose("boot-eureka-order");

        Order order = restTemplate.getForObject(serviceInstance.getUri()+ "/order/findById/2", Order.class);
        return order;
    }

    //Ribbion负载均衡写法二
    @RequestMapping(value = "/order/balance2", method = RequestMethod.GET)
    public Order orderBalance2(){

        //默认负载均衡算法：轮询
        Order order = restTemplate.getForObject("http://boot-eureka-order/order/findById/3", Order.class);
        return order;
    }

}