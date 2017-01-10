package com.sinovoice.test.dao;

import java.util.List;

import com.sinovoice.test.bean.User;

public interface UserDAO {
	/**
	 * 向数据库中添加用户
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 向数据库中更新用户
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Integer id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 根据Id查询用户信息
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
}
