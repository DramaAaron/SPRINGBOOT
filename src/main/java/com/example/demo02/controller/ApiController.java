package com.example.demo02.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo02.model.User;
import com.example.demo02.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    // 用户Servic对象
    @Autowired
    private UserService userService;

    /**
     * 所有用户信息取得
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAllUser() {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            List<User> list = this.userService.listAllUser();
            result.put("status", "ok");
            result.put("list", list);
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
        //return "allusers";
    }

    /**
     * 指定用户信息取得
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Object getUserDetail(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = this.userService.getUser(id);
//            if (user != null) {
//                result.put("status", "ok");
                  result.put("user", user);
//            } else {
//                result.put("status", "failure");
//                result.put("errMsg", "用户不存在");
//            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 创建用户信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createUser(@RequestParam(value = "id", required = true) Long id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             @RequestParam(value = "email", required = false) String email) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setMobile(mobile);
            user.setEmail(email);
            User cnt = this.userService.createUser(user);
            //if (cnt > 0) {
                result.put("status", "ok");
                result.put("user", user);
            //} else {

            //}
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object deleteUser(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            this.userService.deleteUser(id);
           // if (cnt > 0) {
                result.put("status", "ok");
          //  } else {

           // }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }
}