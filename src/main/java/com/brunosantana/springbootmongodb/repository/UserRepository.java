package com.brunosantana.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunosantana.springbootmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
