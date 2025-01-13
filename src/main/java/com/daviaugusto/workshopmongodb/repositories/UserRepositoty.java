package com.daviaugusto.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.daviaugusto.workshopmongodb.domain.User;

@Repository
public interface UserRepositoty extends MongoRepository<User, String>{

}
