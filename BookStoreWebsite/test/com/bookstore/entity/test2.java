package com.bookstore.entity;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Users.class)
				                .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Users user = new Users();
		user.setEmail("Huiyi@gmail.com");
		user.setFullName("Huiyi Wang");
		user.setPassword("123456");
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
		System.out.println("user got injected");
		

	}

}
