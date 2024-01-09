package com.example.supplychain1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.supplychain1.model.Users;
import com.example.supplychain1.repository.UsersRepository;
import com.example.supplychain1.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository repo;

    @Autowired
    PasswordEncoder thePasswordEncoder;


    public Users insert(Users theUsers){
        Users newUsers=new Users();
        try{
            theUsers.setPassword(thePasswordEncoder.encode(theUsers.getPassword()));
            newUsers=repo.save(theUsers);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newUsers;
    }

    public List<Users> getAllData(){
        try{
            return repo.findAll();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Users update(Users theUsers){
        Users newUsers=new Users();
        try{
            newUsers= repo.save(theUsers);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newUsers;
    }

    public Optional<Users> getById(String email_id){
        try {
            return repo.findById(email_id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean delete(String email_id){
        try{
            repo.deleteBy_id(email_id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
