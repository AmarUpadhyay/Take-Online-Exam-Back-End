package com.capgemini.toe.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	

	private User existingUser=new User();
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		return new ResponseEntity<User>(loginService.addUser(user),HttpStatus.CREATED);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<?> updateUserProfile(@PathVariable long userId,@RequestBody User user){
		existingUser=loginService.getUserByUserId(userId);
		BeanUtils.copyProperties(user, existingUser, "userId");
		return new ResponseEntity<>(loginService.updateUserProfile(userId, existingUser),HttpStatus.OK);
	}
}

