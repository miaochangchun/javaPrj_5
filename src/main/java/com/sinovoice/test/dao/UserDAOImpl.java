package com.sinovoice.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sinovoice.test.bean.HibernateUtil;
import com.sinovoice.test.bean.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		HibernateUtil.sessionFactory.close();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
		HibernateUtil.sessionFactory.close();
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setId(id);
		session.delete(user);
		transaction.commit();
		session.close();
		HibernateUtil.sessionFactory.close();
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		String hql = "From User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		session.close();
		HibernateUtil.sessionFactory.close();
		return list;
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		String hql = "From User U where U.id = " + id;
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		session.close();
		HibernateUtil.sessionFactory.close();
		return list.get(0);
	}

}
