// package com.example.supplychain1.service.impl;

// import io.jsonwebtoken.*;
// import jakarta.servlet.http.HttpServletRequest;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.stereotype.Service;

// @Service
// public class LoginService {
//     public String generateToken(String name){
//         Map<String,Object> map=new HashMap<>();
//         map.put("Role","admin");
//         Claims claims = Jwts.claims().setSubject(name);
//         claims.putAll(map);
//         String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").compact();
//         Claims claims2= JwtParser();
//         String roleFromToken=
//         return token;
//     }
//     public Boolean validateToken(String tokenGot,String tokenGenerate){
//         if(tokenGot.equals(tokenGenerate)){
//             return true;
//         }
//         return false;
//     }
// }
