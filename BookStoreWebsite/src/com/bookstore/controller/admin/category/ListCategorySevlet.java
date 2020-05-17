package com.bookstore.controller.admin.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryServices;


@WebServlet(name = "ListCategoryServlet", urlPatterns = { "/admin/list_category" })
public class ListCategorySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCategorySevlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices categoryService = new CategoryServices(request);
		List<Category> categories = categoryService.listCategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/admin/category_list.jsp").forward(request, response);
	}

}
