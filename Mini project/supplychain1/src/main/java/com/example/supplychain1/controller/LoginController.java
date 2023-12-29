package com.example.supplychain1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain1.service.impl.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController { 
    @Autowired
    LoginService loginService;

    @PostMapping("/{username}/{pwd}")
    String login(@PathVariable String username, @PathVariable String pwd ){
        return loginService.generateToken(username);
    }

    @GetMapping("/validate/{name}")
    public String validate(@PathVariable String username,HttpServletRequest request) {
        return loginService.validateToken(request.getHeader("Authorization").split(" ",2)[1],username);
    }
}
