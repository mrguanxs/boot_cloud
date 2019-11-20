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

    User save(User user);

    User update(User user);

    void deleteById(Integer id);
}
