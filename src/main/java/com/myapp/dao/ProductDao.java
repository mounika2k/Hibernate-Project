package com.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Category;
import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;

public class ProductDao {
	//Write Hql:Hibernate query language to communicate eith the database.
	//CRUD: save: findAll :findById :update :delete
	public void saveProduct(Product product, Long catID) {
		Transaction transaction = null;
		Category category=null;
		try {
			//open the session
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save operationO
			category =session.get(Category.class, catID);
			product.setCategory(category);
			session.save(product);
			//commit transaction
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}
		
		public Product findProductById(Long id) {
			Transaction transaction = null;
			Product product = null;
			try {
				//open the session
				Session session = HibernateUtil.getSessionFactory().openSession();
				//start the transaction
				transaction = session.beginTransaction();
				//save operation
				product=session.get(Product.class,id);
				//commit transaction
				transaction.commit();
				
	} catch(Exception e) {
		if(transaction!=null) 
			transaction.rollback();
		e.printStackTrace();
		
	}return product;
		
		
	}
		public List<Product> findAllProducts(){
			Transaction transaction=null;
			List<Product> list=null;
			try {
				//open the session
				Session session =HibernateUtil.getSessionFactory().openSession();
				//start the transaction
				transaction = session.beginTransaction();
				//fetch the product based on id
				list=session.createQuery("from Product",Product.class).list();
				//commit transaction
				transaction.commit();
			}
			catch(Exception e) {
				if(transaction!=null)
					transaction.rollback();
				e.printStackTrace();
			}
			return list;
		}
		public void updateProduct(Product product) {
			Transaction transaction =null;
			try {
				//open the session
				Session session = HibernateUtil.getSessionFactory().openSession();
				//start the transaction
				transaction = session.beginTransaction();
				//save operation
				session.saveOrUpdate(product);
				//commit transaction
				transaction.commit();
				
	} catch(Exception e) {
		if(transaction!=null) 
			transaction.rollback();
		e.printStackTrace();
		
	}
		}
		public void deleteProduct(Long id) {
			Transaction transaction =null;
			Product product=null;
			try {
				//open the session
				Session session = HibernateUtil.getSessionFactory().openSession();
				//start the transaction
				transaction = session.beginTransaction();
				
				product=session.get(Product.class,id);
				if(product!=null) {
					session.delete(product);
				}
				//commit transaction
				transaction.commit();
				
	} catch(Exception e) {
		if(transaction!=null) 
			transaction.rollback();
		e.printStackTrace();
		
	}
		}
		

}
