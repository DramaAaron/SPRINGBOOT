package com.example.demo02.dao;

import com.example.demo02.model.UserMN;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/11/14 0014 13:31
 */
@Repository
public interface UserRepository  extends MongoRepository<UserMN, String> {
}
