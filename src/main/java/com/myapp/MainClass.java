package com.myapp;

import com.myapp.dao.EmployeeDao;
import com.myapp.model.Employee;

public class MainClass {
	public static void main(String[] args) {
		
		
//		
	//ProductDao productDao = new ProductDao();
	//Product p1=new Product(0L,"realme","It is a realme mobilel",99308);
		//productDao.saveProduct(p1,3L);
//		
		//Product product = productDao.findProductById(1L);
		//System.out.println(product);
		
		//productDao.findAllProducts().stream().forEach(p->{System.out.println(p);});
		//for(Product p:productDao.findAllProducts()) {
			//System.out.println(p);
		//}
		//Product p2=new Product(2L,"Maruti Ertiga VDI","It is 2018 diseal model",92839392);
		//productDao.updateProduct(p2);
		
		//productDao.deleteProduct(2L);
		
		//Category c1=new Category(0L,"Mobile");
		//CategoryDao catdao=new CategoryDao();
		//catdao.save(c1);
		
		//StudentDao studentdao=new StudentDao();
		//Address addr=new Address("kalamandir","velpur","522646");
		//Student s1=new Student(0L,"mounika",2,"mounika233","Mjhsjd",addr);
		//studentdao.saveStudent(s1);
		//System.out.println(productDao.findAllProducts());
		//System.out.println(studentdao.getDetailsByStudent("mounika233", "Mjhsjd"));
		
		EmployeeDao employeeDao=new EmployeeDao();
//		Employee e1=new Employee(0L,"Harry Potter",90000);
//		Employee e2=new Employee(0L,"Ron Wesley",80000);
//		Employee e3=new Employee(0L,"Hermoine Granger",95000);
//		Employee e4=new Employee(0L,"Prof Snape",180000);
//		Employee e5=new Employee(0L,"Principal Dumbledor",380000);
//
//		employeeDao.saveEmployee(e1);
//		employeeDao.saveEmployee(e2);
//		employeeDao.saveEmployee(e3);
//		employeeDao.saveEmployee(e4);
//		employeeDao.saveEmployee(e5);
//		
		employeeDao.getAllEmployee().stream().forEach(p->{System.out.println(p);});
		
	}

}
