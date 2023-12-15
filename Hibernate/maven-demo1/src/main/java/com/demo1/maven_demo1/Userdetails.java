package com.demo1.maven_demo1;

//import javax.persistence.*;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")

public class Userdetails implements Serializable{
	
	@Id
	
    @Column(name = "user_id")
	public String userid;
	
    @Column(name = "email")
    public String email;
    
    @Column(name = "verified")
    public boolean verified;
    
    @Column(name = "phonenumber")
    public String phonenumber;
    
    @Column(name = "DOB")
    public String DOB;
    
    @Column(name = "pwd")
    public String password;
	
	
}