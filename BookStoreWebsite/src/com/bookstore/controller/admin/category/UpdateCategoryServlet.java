package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryServices;

@WebServlet("/admin/update_category")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCategoryServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CategoryServices categoryService = new CategoryServices(request);
    	int id = Integer.parseInt(request.getParameter("id"));
    	Category category = categoryService.findCategory(id);
    	request.setAttribute("category", category);
    	request.getRequestDispatcher("/admin/category_form.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices categoryService = new CategoryServices(request);
		boolean updated = categoryService.updateCategory();
		if(updated) {
			response.sendRedirect(request.getContextPath()+"/admin/list_category");
		}else {
			request.setAttribute("message", request.getParameter("name")+" has existed");
			request.getRequestDispatcher("/admin/message.jsp").forward(request,response);
		}
	}

}
