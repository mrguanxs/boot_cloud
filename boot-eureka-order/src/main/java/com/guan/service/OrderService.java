package com.guan.service;

import com.guan.pojo.Order;

import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/20
 */
public interface OrderService {

    List<Order> findAll();

    Order findById(Integer id);
}
