package com.guan.service;

import com.guan.pojo.User;

import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/20
 */
public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    int save(User user);

    int update(User user);

    int deleteById(Integer id);
}
