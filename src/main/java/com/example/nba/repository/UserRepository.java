package com.example.nba.repository;

import com.example.nba.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User getUserById(String id);



}
