package com.web.dao;

import com.web.model.UserDetail;

public interface UserDAO {
	public boolean addUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail getUser(String userName);
}