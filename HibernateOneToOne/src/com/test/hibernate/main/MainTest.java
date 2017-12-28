package com.test.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.test.OneToOneUni.Address;
import com.test.OneToOneUni.Employee;
import com.test.hibernate.main.HibernateUtil;

public class MainTest {

	public static void main(String[] args) {

		// Prep Work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// save example - with transaction
		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		Employee emp1 = getTestEmployee();
		long id1 = (Long) session1.save(emp1);
		System.out.println("2. Employee save called with transaction, id=" + id1);
		System.out.println("3. Before committing save transaction");
		tx1.commit();
		System.out.println("4. After committing save transaction");
		System.out.println("*****");

		// Close resources
		sessionFactory.close();

	}

	public static Employee getTestEmployee() {
		Employee emp = new Employee();
		Address add = new Address();
		emp.setName("Test Emp");
		emp.setSalary(1000);
		add.setAddressLine1("Test address1");
		add.setCity("Test City");
		add.setZipcode("12121");
		emp.setAddress(add);
		return emp;
	}
}