package com.capgemini.toe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.toe.entity.Question;
import com.capgemini.toe.entity.User;
import com.capgemini.toe.service.LoginService;

@RestController
@RequestMapping("/api/loginController")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		return new ResponseEntity<User>(loginService.addUser(user),HttpStatus.CREATED);
	}

}
