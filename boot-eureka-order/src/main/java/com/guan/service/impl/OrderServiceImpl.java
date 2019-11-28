package com.guan.service.impl;

import com.guan.dao.OrderDao;
import com.guan.pojo.Order;
import com.guan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }


    /**
     * 注意：查不到会报错
     * @param id
     * @return
     */
    @Override
    public Order findById(Integer id) {
        return orderDao.findById(id).get();
    }

}
