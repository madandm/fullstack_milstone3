package com.iiht.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.stock.entity.UserEntity;
import com.iiht.stock.repository.UserRepository;

@Service
public class UserBusiness implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public UserEntity findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public UserEntity updateUser(UserEntity user) {
		return userRepository.save(user);
	}
	public void changpassword(String pwd, String userName) {
		userRepository.changpassword(pwd, userName);
	}
}
