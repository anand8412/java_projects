package com.jspserv.dao;

import com.jspserv.model.User;

public interface IUserDAO {
	public void insert(User user);

	public boolean delete(int userId);

	public void update(User user);

	public User  getUser(int userId);
	
	public User[] getUsers();

}
