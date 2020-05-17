package com.bookstore.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class JpaDAO<E> {
	SessionFactory factory;
	
	public JpaDAO() {
	}

	public JpaDAO(SessionFactory factory) {
		this.factory = factory;
	}
	
	public E create(E entity) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
		return entity;
	}
	
	public E update(E entity) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
		return entity;
	}
	
	public E find(Class<E> type, Object id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		E entity = session.find(type, id);
		session.getTransaction().commit();
		session.close();
		return entity;
	}
	
	public void delete(Class<E> type, Object id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Object refer = session.getReference(type, id);
		session.remove(refer);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<E> findWithNamedQuery(String queryName, Class<E> type, String paramName, String paramValue) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<E> result = session.createNamedQuery(queryName, type).setParameter(paramName, paramValue).getResultList();
		session.close();
		return result;
	}
	
	public List<E> findWithNamedQuery(String queryName, Class<E> type){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<E> list = session.createNamedQuery(queryName, type).getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public long countWithNameQuery(String queryName) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Long count = (long) session.createNamedQuery(queryName).getSingleResult();
        session.getTransaction().commit();
        session.close();
		return count;
	}

}
