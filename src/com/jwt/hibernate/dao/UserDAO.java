package com.jwt.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.User;

public class UserDAO {

	public void addUserDetails(String firstName, String lastName, int age) {
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			User user = new User();
			user.setId(91);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setAge(age);
			session.persist(user);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

}
