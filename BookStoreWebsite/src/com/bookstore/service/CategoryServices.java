package com.bookstore.service;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryServices {
	private static SessionFactory factory;
	private static CategoryDAO categoryDAO;
	private HttpServletRequest request;
	
	public CategoryServices(HttpServletRequest request) {
		this.request = request;
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.buildSessionFactory();

		categoryDAO = new CategoryDAO(factory);
	}
	
	public List<Category> listCategory() throws ServletException, IOException {
		return categoryDAO.listAll();	
	}
	
	public boolean createCategory()throws ServletException, IOException {
		String name = request.getParameter("name");
		/* check if category is already existed */
		Category category = categoryDAO.findByName(name);
		if (category == null) {
			/* create new category if not found */
			category = new Category(name);
			categoryDAO.create(category);
			return true;
		}else {
			return false;
		}
	}
	
	public Category findCategory(int id) throws ServletException, IOException {
		Category category = categoryDAO.get(id);
		return category;
	}
	
	public boolean updateCategory() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Category category = categoryDAO.findByName(name);
		if (category == null) {
			category = new Category(id, name);
			categoryDAO.update(category);
			return true;
		}else {
			return false;
		}
	}
	
	public void deleteCategory() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(id);
	}
}
