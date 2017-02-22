package com.kaikeba.mapper;

import com.kaikeba.bean.User;

public interface UserMapper {

	public User findUserById(int id) throws Exception;
}
