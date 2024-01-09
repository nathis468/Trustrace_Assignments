package com.example.supplychain1.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.supplychain1.filter.AuthFilter;
import com.example.supplychain1.service.impl.UsersEntityService;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    UsersEntityService usersEntityService;

    @Autowired
    AuthFilter authFilter;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.GET,"/suppliers/alldata").permitAll())
        .authorizeHttpRequests(requests -> requests.requestMatchers("/auth/**","/suppliers/getById/{*id}").permitAll())
                // .authorizeHttpRequests(requests -> requests.requestMatchers("/**").authenticated())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider newDaoAuthenticationProvider=new DaoAuthenticationProvider();
        newDaoAuthenticationProvider.setUserDetailsService(usersEntityService);
        newDaoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return newDaoAuthenticationProvider;
    }
}
