package com.capgemini.toe.service;

import com.capgemini.toe.entity.User;
import com.capgemini.toe.exception.UserDoesNotExistException;

public interface LoginService {
	
	public boolean checkIfUserExist(String userEmail);
	public User addUser(User user);
	public User updateuser(long userId,User user);
	public User getUserByUserId(long userId) throws UserDoesNotExistException;
	public User updateUserProfile(long userId,User user);
}
