package DAO;

import java.sql.SQLException;

import DTO.UserDTO;

public interface UserDAO {
	/**
	 * ȸ�������ϱ�
	 * "insert into USERINFO(id, password, residence) values(?, ?, ?)"
	 * 
	 */
	UserDTO signUp(String id, String password, int residence) throws SQLException;
	
	/**
	 * �α����ϱ�
	 */
	
	UserDTO logIn(String id, String password);
	
	/**
	 * �� ������ �˻�
	 * "select RESIDENCE from USERINFO where id = 'id'"
	 */
	
	String myResidence(String id) throws SQLException;
	
	
	/**
	 * ġ�ȵ�� Ȯ��
	 * "select RESPONSIBILITY from POLICE where xxx"
	 * 
	 */
	
	int checkSecurity(int residence) throws SQLException;
	
	/**
	 * ������ ����
	 */
	
	void changeResidence(String id) throws SQLException;
	
	/**
	 * ġ�ȵ�� ���γ��� Ȯ��
	 */
	
	UserDTO checkDetail(String id) throws SQLException;
	
	
	

	
}
