package com.guan.controller.call;

import com.guan.client.OrderController;
import com.guan.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignCallController.class);

    @Autowired
    private OrderController orderController;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order order(@PathVariable(value = "id") Integer id){
        LOGGER.info("/feign/call/order");
        //默认负载均衡算法：轮询
        Order order = orderController.findById(id);
        return order;
    }
}
