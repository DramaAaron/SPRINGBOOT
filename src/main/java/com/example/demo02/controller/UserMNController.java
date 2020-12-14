package com.example.demo02.controller;

import com.example.demo02.dao.UserRepository;
import com.example.demo02.model.Student;
import com.example.demo02.model.UserMN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/11/14 0014 13:32
 * description：基于docker上的mongodb实现
 */
@RestController
@RequestMapping("/userMN")
public class UserMNController {
    @Autowired
    private  final UserRepository userRepository;

    public UserMNController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<UserMN> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public UserMN getByUserId(@PathVariable String userId) {
        return userRepository.findById(userId).orElse(new UserMN());
    }

    @PostMapping("")
    public UserMN addNewUser(@RequestBody UserMN user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId) {
        UserMN user = new UserMN();
        user.setUserId(userId);
        userRepository.deleteById(userId);
        return "deleted: " + userId;
    }


    @PutMapping("")
    public UserMN update(@RequestBody UserMN user) {
        return userRepository.save(user);
    }
}
