package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.myapp.model.Employee;
import com.myapp.util.HibernateUtil;

public class EmployeeDao {
	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		Session session=null;
		try {
			//open the session
			 session =HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//save operation
			session.save(employee);
			//commit transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	@SuppressWarnings("deprecation")
	public List<Employee> getAllEmployee(){
		Transaction transaction=null;
		//List<Employee> list=null;
		List<Employee> list=null;
		Session session=null;
		try {
			//open the session
			session =HibernateUtil.getSessionFactory().openSession();
			//start the transaction
			transaction = session.beginTransaction();
			//fetch the product based on id
			Criteria cr=session.createCriteria(Employee.class);
			//cr.add(Restrictions.gt("salary", 90000D));//eq,gt,lt,LIKE
			//cr.add(Restrictions.like("name", "H%"));
			//cr.setProjection(Projections.max("salary"));//min,max,avg,sum
			//list=(List<Double>)cr.list();
			cr.addOrder(Order.desc("salary"));
			//cr.setFirstResult(4);
			cr.setMaxResults(3);
			list=cr.list();
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
}
