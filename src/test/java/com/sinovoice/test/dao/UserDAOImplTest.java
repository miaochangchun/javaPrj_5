package com.sinovoice.test.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sinovoice.test.bean.User;

public class UserDAOImplTest {
	private UserDAO userDao;
	private User user;
	
	@Before
	public void Before(){
		userDao = new UserDAOImpl();
		user = new User();
		user.setPassword("23122123243");
		user.setUsername("username");
	}
	
	@After
	public void After(){
		
	}

	@Test
	public void testAddUser() {
		userDao.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		userDao.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		userDao.deleteUser(4);
	}

	@Test
	public void testFindAllUser() {
		List<User> list = userDao.findAllUser();
		Iterator<User> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testFindUserById() {
		User user = userDao.findUserById(5);
		System.out.println(user);
	}

}
