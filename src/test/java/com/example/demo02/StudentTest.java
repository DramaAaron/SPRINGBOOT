package com.example.demo02;

import com.example.demo02.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/11/6 0006 15:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    StudentService studentService;
    @Test
    public void findAllTest(){
        int count = studentService.findAll().size();
        Assert.assertEquals(6,count);
    }
}
