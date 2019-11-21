package com.guan.mapper;

import com.guan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/21
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);

    int save(User user);

    int update(User user);

    int deleteById(Integer id);
}
