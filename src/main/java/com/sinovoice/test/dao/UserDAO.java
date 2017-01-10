package com.sinovoice.test.dao;

import java.util.List;

import com.sinovoice.test.bean.User;

public interface UserDAO {
	/**
	 * �����ݿ�������û�
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * �����ݿ��и����û�
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * ɾ���û�
	 * @param id
	 */
	void deleteUser(Integer id);
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * ����Id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
}
