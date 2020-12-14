package com.example.demo02.mapper;

import com.example.demo02.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StudentMapper {
    @Insert("insert into student(name,age,sex) values(#{name},#{age},#{sex})")
    public int createStudent(Student student);

    @Select("select * from student")
    List<Student> findAll();

    @Delete("delete from student where id = #{id} ")
    int deleteStudent(Integer id);

    @Update("UPDATE student set name='朱艳迪' WHERE id =#{id}")
    int updateStudent(Integer id);
}
