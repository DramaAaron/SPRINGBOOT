package com.example.demo02.model;


import com.example.demo02.controller.ApiController;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author faz
 * @create 2020-10-25-11:56
 */
@Data
@Component
@Order(1)
@Entity(name ="student")
public class Student implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String age;
    private String sex ;
    /**
     * @author Li Ning
     * @method 实现order的检测
     * @date 2020/11/14 0014 13:28
     */
    @Override
    public void run(String... args) throws Exception {
       // System.out.println(">>>>>>>>>>>>>>>Student服务启动执行，执行加载数据等操作,,order值为1<<<<<<<<<<<<<");
        logger.info(">>>>>>>>>>>>>>>Student服务启动执行，执行加载数据等操作,,order值为1<<<<<<<<<<<<<");

    }
}
