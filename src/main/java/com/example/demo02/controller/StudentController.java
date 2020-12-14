package com.example.demo02.controller;

import com.example.demo02.model.Student;
import com.example.demo02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/11/6 0006 14:10
 * description: 基于docker容器上的
 */

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    public  String cteatStudent(){
        Map<String,String> result = new HashMap<>();
        Student student = new Student();
        student.setName("llll");
        student.setAge("24");
        student.setSex("男");
        int count = studentService.creatStudent(student);
        if(count > 0) {result.put("status","添加成功");
        }else
            result.put("status","添加失败");
        return result.get("status");
    }

    @RequestMapping("/list")
    public List<Student> findAll(){
        List<Student> list = studentService.findAll();
        return list;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStedent(@PathVariable Integer id){
        Map<String,String> result = new HashMap<>();
        int count = studentService.deleteStudent(id);
        if (count > 0) {
            result.put("status", "删除成功");
        } else {
            result.put("status", "删除失败");
        }
        return result.get("status");
    }

    @RequestMapping("update/{id}")
    public String updateStudent(@PathVariable Integer id) {
        Map<String, String> result = new HashMap<>();
        int count = studentService.updateStudent(id);
        if (count > 0) {
            result.put("status", "修改成功");
        } else {
            result.put("status", "修改失败");
        }
        return result.get("status");
    }
}
