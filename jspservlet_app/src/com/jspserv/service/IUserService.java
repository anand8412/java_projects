package com.jspserv.service;

import com.jspserv.model.User;

public interface IUserService {
	public void insert(User user);

	public boolean delete(int userId);

	public void update(User user);

	public User  getUser(int userId);
	
	public User[] getUsers();

}
