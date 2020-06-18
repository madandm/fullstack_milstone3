package com.iiht.stock.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.stock.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity findById(Integer id);
	
	public UserEntity findByUserName(String userName);
	
	@Modifying
	@Transactional
	@Query(value = "update s_user u set u.PASSWORD=? where u.USER_NAME=?",nativeQuery = true)
	public void changpassword(@Param("pwd")String pwd, @Param("name")String name);
}
