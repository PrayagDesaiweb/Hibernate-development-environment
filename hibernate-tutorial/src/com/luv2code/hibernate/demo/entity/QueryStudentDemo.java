package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
	
					
					// start a transaction
					session.beginTransaction();
					
					List<Student> theStudents = session.createQuery("from Student").getResultList();
					for(Student tempStudent : theStudents)
					{
						//System.out.println(tempStudent);
					}
					
					
					//theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
					for(Student tempStudent : theStudents)
					{
						//System.out.println(tempStudent);
					}
					
					theStudents = session.createQuery("from Student s where" + " s.email LIKE '%luv2code.com'").getResultList();
					for(Student tempStudent : theStudents)
					{
						System.out.println(tempStudent);
					}
					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}

	}

}
