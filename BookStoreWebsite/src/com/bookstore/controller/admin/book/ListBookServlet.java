package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.service.BookServices;


@WebServlet("/admin/list_book")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookService = new BookServices(request);
		List<Book> books = bookService.listBook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/admin/book_list.jsp").forward(request, response);
 	}

}
