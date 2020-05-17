package com.bookstore.dao;

import java.util.List;
import org.hibernate.SessionFactory;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(SessionFactory factory) {
		super(factory);
	}

	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll", Users.class);
	}

	@Override
	public long count() {
		return super.countWithNameQuery("Users.countAll");
	}

	public Users findByEmail(String email) {
		List<Users> users = super.findWithNamedQuery("Users.findByEmail", Users.class, "email", email);
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
