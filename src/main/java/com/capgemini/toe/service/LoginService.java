package com.capgemini.toe.service;

import com.capgemini.toe.entity.User;

public interface LoginService {
	
	public boolean checkIfUserExist(String userEmail);
	public User addUser(User user);
	public User updateuser(long userId,User user);

}
