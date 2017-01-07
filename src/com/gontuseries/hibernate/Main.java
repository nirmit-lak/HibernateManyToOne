package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String argsp[])
	{
		StudentAddress studentAddress =new StudentAddress();
		studentAddress.setAddress_detail("Hydrabad,India");
		
		Student student1 = new Student();
		student1.setStudent_name("Gontu1");
		student1.setStudentAddress(studentAddress);
		
		Student student2 =new Student();
		student2.setStudent_name("Gontu2");
		student2.setStudentAddress(studentAddress);

		//(studentAddress.getStudents()).add(student1);
		//(studentAddress.getStudents()).add(student2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		//session.save(studentAddress);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	
}
