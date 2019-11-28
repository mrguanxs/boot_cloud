package com.guan.dao;

import com.guan.pojo.Order;
import com.guan.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mr.Guan
 * @since 2019/11/20
 * 用户dao 使用Spring data jpa 不需要实现类，
 * 继承JpaRepository<Order, Integer>即可，Order为实体，Integer为id数据类型
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
}
