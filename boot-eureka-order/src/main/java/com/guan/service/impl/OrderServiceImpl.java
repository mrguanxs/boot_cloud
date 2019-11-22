package com.guan.service.impl;

import com.guan.pojo.Order;
import com.guan.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        Order order = new Order();
        list.add(order);
        return list;
    }


    /**
     * 注意：查不到会报错
     * @param id
     * @return
     */
    @Override
    public Order findById(Integer id) {
        Order order = new Order();
        order.setId(id);
        return order;
    }

}
