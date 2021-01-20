package com.capgemini.toe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.toe.entity.User;
import com.capgemini.toe.exception.UserAlreadyExistsException;
import com.capgemini.toe.exception.UserDoesNotExistException;
import com.capgemini.toe.repository.UserRepository;
@Service
public class LoginServiceImp implements LoginService{

	@Autowired 
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		if(checkIfUserExist(user.getUserEmail()))
		{
			throw new UserAlreadyExistsException();
		}
		else
			return userRepository.save(user);
	}

  @Override
	public User updateuser(long userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}         
                
	@Override
	public User getUserByUserId(long userId) throws UserDoesNotExistException{
		if(userRepository.existsById(userId)) 
			return userRepository.getOne(userId);
		else
			throw new UserDoesNotExistException();
	}
	@Override
	public User updateUserProfile(long userId,User user) {
		return userRepository.saveAndFlush(user);
	}
	@Override
	public boolean checkIfUserExist(String userEmail) {
		List<User> userList=userRepository.findAll();
		for(User list:userList)
		{
			if(list.getUserEmail().contentEquals(userEmail))
				return true;
			else
				return false;
		}
		return false;
	}

}
