package com.example.demo02.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/11/14 0014 13:28
 */
@Component
@Order(3)
public class UserMN implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    @Id
    private String userId;
    private String name;
    private Integer age;
    private Date createTime = new Date();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @author Li Ning
     * @method 实现order的检测
     * @date 2020/11/14 0014 13:28
     */
    @Override
    public void run(String... args) throws Exception {

       // System.out.println(">>>>>>>>>>>>>>>UserMN服务启动执行，执行加载数据等操作,order值为3<<<<<<<<<<<<<");
        logger.info(">>>>>>>>>>>>>>>UserMN服务启动执行，执行加载数据等操作,order值为3<<<<<<<<<<<<<");
    }
}
