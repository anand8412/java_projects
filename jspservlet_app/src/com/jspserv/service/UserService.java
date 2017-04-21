package com.jspserv.service;

import com.jspserv.dao.IUserDAO;
import com.jspserv.dao.UserDAO;
import com.jspserv.model.User;

public class UserService implements IUserService {

	@Override
	public void insert(User user) {
		IUserDAO userDAO = new UserDAO();
		userDAO.insert(user);

	}

	@Override
	public void delete(int userId) {
		IUserDAO userDAO = new UserDAO();
		userDAO.delete(userId);
	}

	@Override
	public void update(User user) {
		IUserDAO userDAO = new UserDAO();
		userDAO.update(user);
	}

	@Override
	public User getUser(int userId) {
		IUserDAO userDAO = new UserDAO();
		User user = userDAO.getUser(userId);
		return user;
	}

	@Override
	public User[] getUsers() {
		IUserDAO userDAO = new UserDAO();
		User[] users = userDAO.getUsers();
		return users;
	}

}
