package com.example.demo02.service.impl;

import com.example.demo02.dao.UserDao;
import com.example.demo02.mapper.UserMapper;
import com.example.demo02.model.User;
import com.example.demo02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;
    @Override
    public List<User> listAllUser() {
       // List<User> list = userMapper.findAll();

        return userDao.findAll();
    }

    @Override
    public User getUser(Long id) {
      //  User user = userMapper.findOne(id);
        return userDao.getOne(id);
       //userDao.getOne()
    }

    @Override
    public User createUser(User user) {


        return userDao.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        //int cnt = userMapper.delete(id);
        //userDao.deleteById(id);
        //int cnt = (int)userDao.deleteById(id);
        userDao.deleteById(id);
    }

}
