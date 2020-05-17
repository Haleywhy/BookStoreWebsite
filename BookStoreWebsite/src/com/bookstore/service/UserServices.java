package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {
	private static SessionFactory factory;
	private static UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		userDAO = new UserDAO(factory);
	}

	public void listUser(String message) throws ServletException, IOException {
		List<Users> users = userDAO.listAll();
		request.setAttribute("userList", users);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
	}

	public boolean createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		/* check if user is already existed */
		Users user = userDAO.findByEmail(email);
		if (user == null) {
			/* create new user if email is not registered */
			user = new Users(email, fullName, password);
			userDAO.create(user);
			return true;
		}else {
			return false;
		}
	}
	
	public Users findUser(int id) throws ServletException, IOException {
		Users user = userDAO.get(id);
		return user;
	}
	
	public boolean updateUser()throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		/* check if user is already existed */
		Users user = userDAO.findByEmail(email);
		if (user == null || user.getUserId() == id) {
			/* Update user if email is not registered or email belongs to the user*/
			Users userUpdated = new Users(id,email,fullName,password);
			userDAO.update(userUpdated);
			return true;
		}else {
		    return false;
		}
	}
    
	public void deleteUser() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.delete(id);
	}
}
