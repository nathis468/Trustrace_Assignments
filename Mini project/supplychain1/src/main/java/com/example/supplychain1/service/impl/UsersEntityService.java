package com.example.supplychain1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.supplychain1.repository.UsersEntity;
import com.example.supplychain1.repository.UsersRepository;

@Service
public class UsersEntityService implements UserDetailsService{
    @Autowired
    UsersRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity newUserEntity=new UsersEntity(repo.findByUserName(username));
        System.out.println(newUserEntity);
        return newUserEntity;
    }    
}
