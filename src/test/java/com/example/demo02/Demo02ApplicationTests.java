package com.example.demo02;

import com.example.demo02.dao.UserDao;
import com.example.demo02.model.User;
import com.example.demo02.service.UserService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Demo02ApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {

        System.out.println("测试查询id对应用户");
       Optional<User> user = userDao.findById((long)4);
       System.out.println(userDao.getOne((long) 1));
       // User user = userService.getUser((long)4);


        //System.out.println(user.getName());
    }

}
