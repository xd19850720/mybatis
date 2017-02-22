package com.kaikeba.dao;

import com.kaikeba.bean.User;

public interface UserDao {

	public User findUserById(int id) throws Exception;
}
