package com.guan.service.impl;

import com.guan.dao.UserDao;
import com.guan.pojo.User;
import com.guan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


    /**
     * 注意：查不到会报错
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    /**
     * 注意：对象所有值为空id会自增插进去
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    /**
     * 注意：修改也是调用的save方法，必须包含数据库存在的id，否则会插入
     * 即:数据存在则修改，不存在则新增，条件是数据库中是否存在此id
     * @param user
     * @return
     */
    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    /**
     * 注意：不存在的数据删除会报错
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }
}
