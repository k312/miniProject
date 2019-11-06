package service;

import java.sql.SQLException;

public interface UserService {
	
	/**
	 * 회원가입
	 * */
	UserDTO signUP(String id, String password, int residence) throws SQLException;
	
	/**
	 * 로그인
	 * */
	UserDTO logIn(String id, String password, int residence);
	
	/**
	 * 나의 거주지 검색
	 * */
	String myResidence(String id) throws SQLException;;
	
	/**
	 * 치안등급 검색
	 * */
	String checkSecurity(int residence) throws SQLException;
	
	/**
	 * 거주지 전출신고
	 * */
	void changeResidence(String id) throws SQLException;
	
	/**
	 * 지역 치안 상황 상세보기
	 * */
	UserDTO checkDetail(String id) throws SQLException;
}
