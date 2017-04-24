package com.jspserv.service;

import com.jspserv.dao.IUserDAO;
import com.jspserv.dao.UserDAO;
import com.jspserv.model.User;

public class UserService implements IUserService {

	IUserDAO userDAO = null;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void insert(User user) {
		userDAO.insert(user);

	}

	@Override
	public boolean delete(int userId) {
		System.out.println("i was called");
		return userDAO.delete(userId);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public User getUser(int userId) {
		User user = userDAO.getUser(userId);
		return user;
	}

	@Override
	public User[] getUsers() {
		User[] users = userDAO.getUsers();
		return users;
	}

}
