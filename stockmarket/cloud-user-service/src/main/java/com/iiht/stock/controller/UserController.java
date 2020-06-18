package com.iiht.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.stock.entity.UserEntity;
import com.iiht.stock.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	private static final int SUCCESS = 201;
	
	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/search")
	public UserEntity findByUserName(@RequestParam(name="name") String name){
		UserEntity userEntity = userService.findByUserName(name);
		return userEntity;
	}

	@ResponseBody
	@PostMapping("/update")
	public ResponseEntity<UserEntity> update(@RequestBody UserEntity user){
		UserEntity userEntity = userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userEntity); 
	}
	@PostMapping("/pwd")
	public int changepassword(@RequestBody UserEntity user){
		userService.changpassword(user.getPassword(), user.getUserName());
		return SUCCESS;
	}
	
	@PostMapping("/regist")
	public ResponseEntity<UserEntity> regist(@RequestBody UserEntity user){
		UserEntity search = userService.findByUserName(user.getUserName());
		//user exist do nothing
		if(search != null) {
			return new ResponseEntity<UserEntity>(HttpStatus.OK);
		}else {
			//user not exist then insert
			UserEntity userEntity = userService.updateUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(userEntity); 
		}
	}
}
