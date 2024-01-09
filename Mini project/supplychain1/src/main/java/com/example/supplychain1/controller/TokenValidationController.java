// package com.example.supplychain1.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.supplychain1.service.impl.LoginService;

// import jakarta.servlet.http.HttpServletRequest;

// @RestController
// @RequestMapping("/token")
// public class TokenValidationController {
//     @Autowired
//     LoginService loginService;
    
//     @GetMapping("/validate/{username}")
//     public ResponseEntity<?> tokenValidateApi(HttpServletRequest request,String username){
//         String tokenGot=request.getHeader("Authorization").substring(7);
//         String tokenGenerate=loginService.generateToken(username);
//         if(loginService.validateToken(tokenGot,tokenGenerate)){
//             return new ResponseEntity<>("You are Authenticated",HttpStatus.ACCEPTED);
//         }
//         return new ResponseEntity<>("You are not Authenticated",HttpStatus.NOT_FOUND);
//     }
// }
