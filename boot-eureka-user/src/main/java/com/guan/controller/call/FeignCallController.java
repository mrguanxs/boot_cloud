package com.guan.controller.call;

import com.guan.client.OrderController;
import com.guan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Guan
 * @since 2019/11/25
 */
@RestController
@RequestMapping("/feign/call")
public class FeignCallController {

    @Autowired
    private OrderController orderController;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Order orderBalance2(){

        //默认负载均衡算法：轮询
        Order order = orderController.findById(1);
        return order;
    }
}
