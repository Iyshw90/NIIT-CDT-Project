package com.web.dao;

import com.web.model.UserDetail;

/*UserDAO Interface - Blueprint of "UserDAOImpl" class for implementing total abstraction,also used to achieve multiple inheritance*/

public interface UserDAO {
	public boolean addUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail getUser(String userName);
}