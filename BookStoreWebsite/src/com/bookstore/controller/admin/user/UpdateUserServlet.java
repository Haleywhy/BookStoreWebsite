package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;

@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserServices userServices = new UserServices(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		Users user = userServices.findUser(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/user_form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserServices userServices = new UserServices(request, response);
		boolean updated = userServices.updateUser();
		if (updated) {
			userServices.listUser("User has been updated successfully!");
		} else {
			request.setAttribute("message", "User with email " + request.getParameter("email") + " has existed");
			request.getRequestDispatcher("/admin/message.jsp").forward(request, response);
		}
	}

}
