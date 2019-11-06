package service;

import java.sql.SQLException;

import DTO.UserDTO;

public interface UserService {
	
	/**
	 * ȸ������
	 * */
	UserDTO signUp(String id, String password, int residence) throws SQLException;
	
	/**
	 * �α���
	 * */
	UserDTO logIn(String id, String password)throws SQLException;
	
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
	int changeResidence(String id, int residence) throws SQLException;
	
	/**
	 * ���� ġ�� ��Ȳ �󼼺���
	 * */
	String checkDetail(String id) throws SQLException;
}
