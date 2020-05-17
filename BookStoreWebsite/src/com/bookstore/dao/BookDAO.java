package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO(SessionFactory factory) {
		super(factory);
	}
	
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}
	
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}

	@Override
	public Book get(Object id) {
		return super.find(Book.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Book.class, id);	
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("Book.findAll", Book.class);
	}

	@Override
	public long count() {
		return super.countWithNameQuery("Book.countAll");
	}
	
	public Book findByTitle(String title) {
		List<Book> books = super.findWithNamedQuery("Book.findByTitle", Book.class, "title", title);
		if(!books.isEmpty()) {
			return books.get(0);
		}
		return null;
	}
  
}
