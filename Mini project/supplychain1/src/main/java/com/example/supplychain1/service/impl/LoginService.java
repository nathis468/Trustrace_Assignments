package com.example.supplychain1.service.impl;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public String generateToken(String name){
        Claims claims = Jwts.claims().setSubject(name);
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").compact();
        return token;
    }
    public String validateToken(String username,HttpServletRequest request){
        String tokengot = request.getHeader("Authorization");
        tokengot=tokengot.substring(7);
        String token=generateToken(username);
        System.out.println(token+" "+tokengot);
        if(token.equals(tokengot)){
            return "Valid token";
        }
        return "Invalid token";
    }
}
