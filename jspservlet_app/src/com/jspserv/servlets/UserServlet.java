package com.jspserv.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspserv.model.User;
import com.jspserv.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		String action = request.getParameter("action");
		if (action.equals("create")) {

			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String isMarried = request.getParameter("isMarried");

			User user = new User();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setGender(gender);
			user.setIsMarried(isMarried);
			user.setAge(age);

			userService.insert(user);

		} else if (action.equals("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			userService.delete(userId);

		}else if (action.equals("edit")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = userService.getUser(userId);
			request.setAttribute("user", user);
			request.getRequestDispatcher("useredit.jsp").forward(request, response);

		}else if(action.equals("updateuser")){

			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String isMarried = request.getParameter("isMarried");
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = new User();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setGender(gender);
			user.setIsMarried(isMarried);
			user.setAge(age);
			user.setUserId(userId);
			userService.update(user);
		}
		
		User[] users = userService.getUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("success.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
