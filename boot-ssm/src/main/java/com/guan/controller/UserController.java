package com.guan.controller;

import com.guan.pojo.User;
import com.guan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guanxinshuai E-mail:
 * @version 创建时间：2019/11/20 4:19 PM
 * User:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll", method=RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method=RequestMethod.GET)
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public int save(User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public int update(User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/deleteById/{id}", method=RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return "删除成功";
    }
}