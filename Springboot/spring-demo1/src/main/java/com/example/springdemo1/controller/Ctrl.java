package com.example.springdemo1.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class Ctrl{
	@GetMapping("/")
	String egcontroller() {
		return "Hello";
	}
	
	@GetMapping(value={"/val"})
	List<String> eg2controller(@RequestParam(required=false,name="users") List<String> name) {
		return name;
	}
	
	@GetMapping(value={"/hello","/hello/{id}","/hello/"})
	String eg1controller(@PathVariable(required=false,name="uid") String id) {
		return "Hello "+id;
	}
}