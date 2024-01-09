package com.example.supplychain1.filter;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public  class AuthFilter extends OncePerRequestFilter{
    
    String secretKey="tmPvyTA/jc3OAfg4FUA0DNr25OOP49T9fBIUNsZ8xnUuIjEf3XCjngUmKdbKlfag";

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization").substring(7);
        Boolean valid=validateToken(token);
        if(!valid){
            throw new RestClientException("Token is invalid");
        }
        filterChain.doFilter(request, response);
    }
}