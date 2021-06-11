package com.myapp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Category;
import com.myapp.util.HibernateUtil;

public class CategoryDao {
	
	public void save(Category category) {
		Transaction transaction = null;
		try {
			//open the session
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save operation
			session.save(category);
			//commit transactionO
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}

}
