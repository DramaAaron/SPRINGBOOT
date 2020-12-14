package com.example.demo02.service;

import com.example.demo02.model.Student;

import java.util.List;

public interface StudentService {
        int creatStudent(Student student);

        List<Student> findAll();

        int deleteStudent(Integer id);

        int updateStudent(Integer id);


}
