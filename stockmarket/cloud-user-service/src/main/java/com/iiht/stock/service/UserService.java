package com.iiht.stock.service;

import com.iiht.stock.entity.UserEntity;

public interface UserService {
	
	/**
	 * findUserById
	 * 
	 * @return
	 */
	public UserEntity findUserById(Integer id);
	
	/**
	 * findUserById
	 * 
	 * @return
	 */
	public UserEntity findByUserName(String userName);
	
	/**
	 * updateUser
	 * 
	 * @param user
	 * @return
	 */
	public UserEntity updateUser(UserEntity user);
	
	public void changpassword(String pwd, String userName);
	
}
