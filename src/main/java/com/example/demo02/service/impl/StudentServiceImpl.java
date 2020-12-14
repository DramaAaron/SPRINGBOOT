package com.example.demo02.service.impl;

import com.example.demo02.mapper.StudentMapper;
import com.example.demo02.model.Student;
import com.example.demo02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired(required = false)
    StudentMapper studentMapper;
    @Resource
    RedisTemplate redisTemplate;

    @Override
    public int creatStudent(Student student) {
        return studentMapper.createStudent(student);
    }

    @Override

    public List<Student> findAll() {
        String key = "student";
        ListOperations<String, Student> operations = redisTemplate.opsForList();
        //缓存存在
        if (redisTemplate.hasKey(key)) {
            return operations.range(key, 0, -1);
        } else {
            //得到学生集合
            List<Student> list = studentMapper.findAll();
            operations.leftPushAll(key, list);
            return list;
        }
        //return studentMapper.findAll();
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int updateStudent(Integer id) {
        return studentMapper.updateStudent(id);
    }
}
