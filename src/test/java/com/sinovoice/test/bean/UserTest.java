package com.sinovoice.test.bean;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setPassword("qwert12345");
		user.setUsername("miaochangchun");
		session.save(user);
		transaction.commit();
		session.close();
		HibernateUtil.sessionFactory.close();
	}

}
