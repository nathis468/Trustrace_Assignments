package com.example.supplychain1.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationService {
    String secretKey="tmPvyTA/jc3OAfg4FUA0DNr25OOP49T9fBIUNsZ8xnUuIjEf3XCjngUmKdbKlfag";
    
    public String getToken(String username, String pwd) {
        Claims claim=Jwts.claims().setSubject(username);
        String token=Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS256, secretKey).compact();
        System.out.println(token);
        return token;
    }

    public String generateToken(String username, String pwd) {
        Claims claim=Jwts.claims().setSubject(username);
        Map <String,Object> map=new HashMap<>();
        map.put("Role","admin");
        claim.putAll(map);
        String token=Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS256,secretKey).compact();
        Claims claims=Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        String role=claims.get("Role").toString();
        System.out.println(role);
        return token;
    }

    public String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); 
        }
        return null;
    }

    public boolean validateToken(String token,String username) {
        System.out.println( "token "+token);
        String tokengot=getToken(username,"");
        if(tokengot.equals(token))
            return true;
        return false;
    }
    
}
