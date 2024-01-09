package com.example.supplychain1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain1.model.Users;
import com.example.supplychain1.service.UsersService;
import com.example.supplychain1.service.impl.AuthenticationService;

@RestController
@RequestMapping(path="auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService theAuthenticationService;

    @Autowired
    UsersService theUsersService;

    @PostMapping("/insert")
    public Users insertData(@RequestBody Users theUsers){
        return theUsersService.insert(theUsers);
    }
    
    @PostMapping("/{username}/{pwd}")
    public String login(@PathVariable String username, @PathVariable String pwd){
        return theAuthenticationService.getToken(username,pwd);  
    }

    @PostMapping("role/{username}/{pwd}")
    public String roleLogin(@PathVariable String username, @PathVariable String pwd){
        return theAuthenticationService.generateToken(username,pwd);  
    }

    @GetMapping("/validate/{username}")
    public ResponseEntity<String> tokenValidation(@RequestHeader("Authorization") String authorizationHeader,@PathVariable String username) {
        String token=theAuthenticationService.extractToken(authorizationHeader);
        if (theAuthenticationService.validateToken(token,username)) {
            return ResponseEntity.ok("Valid token");
        } 
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
    }  

    @ExceptionHandler(value=RuntimeException.class)
     public ResponseEntity<?> runtimeExeHandle(){
        return new ResponseEntity<>("Runtime Exception occured", HttpStatus.BAD_REQUEST);
    }

     @ExceptionHandler(value=IllegalArgumentException.class)
     public ResponseEntity<?> IllegalArgumentException(){
        return new ResponseEntity<>("Illegal Argument Exception occured", HttpStatus.BAD_REQUEST);
    }
}