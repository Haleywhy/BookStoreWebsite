package com.bookstore.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bookstore.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(SessionFactory factory) {
		super(factory);
	}

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll", Category.class);
	}

	@Override
	public long count() {
		return super.countWithNameQuery("Category.countAll");
	}

	public Category findByName(String name) {
		List<Category> category = super.findWithNamedQuery("Category.findByName", Category.class, "name", name);
		if (category.isEmpty()) {
			return null;
		} else {
			return category.get(0);
		}
	}

}
