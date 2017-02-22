package com.kaikeba.mapper;

import java.util.List;

import com.kaikeba.bean.User;

public interface UserMapper {

	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String username) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void updateUserById(User user) throws Exception;
	public int findUserCount(User user) throws Exception;
}
