package com.bookstore.service;

import java.io.IOException;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices {
	private static SessionFactory factory;
	private static BookDAO bookDAO;
	private HttpServletRequest request;
	
	public BookServices(HttpServletRequest request) {
		this.request = request;
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
				.buildSessionFactory();

		bookDAO = new BookDAO(factory);
	}
	
	public List<Book> listBook(){
		return bookDAO.listAll();
	}
	
	public Boolean createBook() throws ServletException, IOException {
		String title = request.getParameter("title");
		
		Book book = bookDAO.findByTitle(title);
		if(book != null) {
			return false;
		}
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date publishDate = null;
		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
			
		}catch (ParseException ex){
			ex.printStackTrace();
			throw new ServletException("Error parsing publish date (correct format: mm/dd/yyyy)");
		}
		
		Book newBook = new Book();
		newBook.setAuthor(author);
		newBook.setDescription(description);
		newBook.setIsbn(isbn);
		newBook.setTitle(title);
		newBook.setPublishDate(publishDate);
		newBook.setPrice(price);
		
		Category category = new CategoryDAO(factory).get(categoryId);
		newBook.setCategory(category);
		
	    Part part = request.getPart("image");
		if(part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newBook.setImage(imageBytes);
		}
		
	    bookDAO.create(newBook);
        return true;		
	}
}
