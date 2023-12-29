package com.example.supplychain1.service.impl;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public String generateToken(String name){
        Claims claims = Jwts.claims().setSubject(name);
        System.out.println(claims);
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").compact();
        System.out.println(token);
        return token;
    }
    public String validateToken(String token,String name){
        if(token.equals(generateToken(name))){
            return "Valid";
        }
        return "Invalid";
    }
}
