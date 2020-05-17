package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.BookServices;
import com.bookstore.service.CategoryServices;

@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,	// 10 KB
		maxFileSize = 1024 * 300,		// 300 KB
		maxRequestSize = 1024 * 1024	// 1 MB 
)
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateBookServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices categoryService = new CategoryServices(request);
		List<Category> categoryList = categoryService.listCategory();
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/admin/book_form.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookService = new BookServices(request);
		Boolean created = bookService.createBook();
		if(created) {
			response.sendRedirect(request.getContextPath()+"/admin/list_book");
		}else {
			request.setAttribute("message", request.getParameter("title")+" has existed");
			request.getRequestDispatcher("/admin/message.jsp").forward(request,response);
		}
	}

}
