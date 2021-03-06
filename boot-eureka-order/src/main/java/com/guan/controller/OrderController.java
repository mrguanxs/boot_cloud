package com.guan.controller;

import com.guan.pojo.Order;
import com.guan.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guanxinshuai E-mail:
 * @version 创建时间：2019/11/20 4:19 PM
 * User:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/findAll", method=RequestMethod.GET)
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method=RequestMethod.GET)
    public Order findById(@PathVariable Integer id){
        LOGGER.info("/findById/{}",id);
        return orderService.findById(id);
    }


}