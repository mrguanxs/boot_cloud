package com.guan.client;

import com.guan.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/25
 * FallBack处理类，要实现调用的代理接口
 */
@Component      //注解不能少
public class OrderControllerFallBack implements OrderController {
    @Override
    public Order findById(Integer id) {
        System.out.println("熔断了，order挂了");
        return null;
    }

    @Override
    public List<Order> findAll() {
        System.out.println("熔断了，order挂了");
        return null;
    }
}
