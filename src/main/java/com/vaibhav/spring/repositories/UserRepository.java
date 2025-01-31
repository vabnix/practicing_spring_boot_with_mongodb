package com.vaibhav.spring.repositories;

import com.vaibhav.spring.data.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserData, String> {


}
