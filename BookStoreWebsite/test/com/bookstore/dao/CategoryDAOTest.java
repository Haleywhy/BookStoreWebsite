package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;

import org.junit.BeforeClass;

import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class CategoryDAOTest {
	private static SessionFactory factory;
	private static BookDAO bookdao;
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        
		bookdao = new BookDAO(factory);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		factory.close();
	}
	
	@Test
	public void testcreateBook() throws ParseException, IOException{
	    Book list = bookdao.findByTitle("Core Java");
	    assertTrue(list.getBookId() == 2);
	}
	
}
