package com.example.demo02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo02.model.User;

@Mapper
public interface UserMapper {

    /**
     * 查询指定ID的数据
     *
     * @param id
     * @return
     */
    public User findOne(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 插入数据
     *
     * @param data
     * @return
     */
    public int insert(User data);

    /**
     * 删除指定ID的数据
     *
     * @param id
     * @return
     */
    public int delete(Long id);

}