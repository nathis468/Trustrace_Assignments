package com.example.supplychain1.repository;

import com.example.supplychain1.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface UsersRepository extends MongoRepository<Users, String> {
    Boolean deleteBy_id(String email_id);
    Users findByUserName(String userName);
}
