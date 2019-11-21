package com.guan.controller;

import com.guan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mr.Guan
 * @since 2019/11/21
 * 使用RestTemplate进行远程调用测试
 * 缺点：1. ip地址硬编码，不好维护
 *      2. 服务提供方是否存活未知
 *      3. 负载均衡需要手动编码，不好实现
 *      4. 容灾
 */
@RequestMapping("/rest")
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findById/{id}", method= RequestMethod.GET)
    public User findById(@PathVariable Integer id){

        return restTemplate.getForObject("http://localhost:8080/user/findById/" + id, User.class);
    }
}
