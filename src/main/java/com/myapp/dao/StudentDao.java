package com.myapp.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Address;
import com.myapp.model.Product;
import com.myapp.model.Student;
import com.myapp.util.HibernateUtil;

public class StudentDao {
	public void saveStudent(Student student) {
		Transaction transaction = null;
		//Category category=null;
		try {
			//open the session
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save operationO
			
			session.save(student);
			//commit transaction
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		
	}
	public Address getAddressByStudetId(Long sid) {
		Transaction transaction = null;
		Address address=null;
		Session session=null;
		
		try {
			//open the session
			 session=HibernateUtil.getSessionFactory().openSession();
			//start the session
			transaction=session.beginTransaction();
			//fetch the address based on student_id
			Query q=session.createQuery("select s.address from Student s where s.id=:id");
			q.setParameter("id", sid);
			address=(Address) q.getSingleResult();
			//commit transaction
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return address;
	}
	
	public Student getDetailsByStudent(String susername,String spassword) {
		Transaction transaction = null;
		Student student=null;
		Session session=null;
		
		try {
			//open the session
			 session=HibernateUtil.getSessionFactory().openSession();
			//start the session
			transaction=session.beginTransaction();
			//fetch the address based on student_id
			Query q=session.createQuery("from Student s where s.username=:username and s.password=:password");
			q.setParameter("username", susername);
			q.setParameter("password", spassword);
			student=(Student) q.getSingleResult();
			//commit transaction
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return student;
	}
	

}
