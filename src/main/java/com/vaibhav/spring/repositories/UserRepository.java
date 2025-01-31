package com.vaibhav.spring.repositories;

import com.vaibhav.spring.data.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserData, String> {


}
