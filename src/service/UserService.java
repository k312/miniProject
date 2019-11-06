package service;

import java.sql.SQLException;

public interface UserService {
	
	/**
	 * ȸ������
	 * */
	UserDTO signUP(String id, String password, int residence) throws SQLException;
	
	/**
	 * �α���
	 * */
	UserDTO logIn(String id, String password, int residence);
	
	/**
	 * ���� ������ �˻�
	 * */
	String myResidence(String id) throws SQLException;;
	
	/**
	 * ġ�ȵ�� �˻�
	 * */
	String checkSecurity(int residence) throws SQLException;
	
	/**
	 * ������ ����Ű�
	 * */
	void changeResidence(String id) throws SQLException;
	
	/**
	 * ���� ġ�� ��Ȳ �󼼺���
	 * */
	UserDTO checkDetail(String id) throws SQLException;
}
