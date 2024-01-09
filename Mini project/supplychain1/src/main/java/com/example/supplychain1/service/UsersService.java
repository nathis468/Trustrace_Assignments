package com.example.supplychain1.service;

import java.util.List;
import java.util.Optional;

// import org.springframework.web.multipart.MultipartFile;

import com.example.supplychain1.model.Users;

public interface UsersService {
    List<Users> getAllData();
    Optional<Users> getById(String id);
    Users insert(Users theUsers);
    Users update(Users theUsers);
    Boolean delete(String id);
    // Boolean uploadImageToDB(Users theUsers , MultipartFile file);
    // byte[] downloadImage(Users theUsers);
}
