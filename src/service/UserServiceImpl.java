package service;

import java.sql.SQLException;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import DTO.UserDTO;

public class UserServiceImpl implements UserService {
	UserDAO dao = new UserDAOImpl();

	@Override
	public UserDTO signUp(String id, String password, int residence) throws SQLException {
		UserDTO dto = dao.signUp(id, password, residence);
		if(dto.getId().equals(id)) {
			throw new SQLException("�̹� ���Ե� ���̵� �Դϴ�.");
		}		
		return dto;
	}

	@Override
	public UserDTO logIn(String id, String password) throws SQLException {
		UserDTO dto = dao.logIn(id, password);
		if(dto==null) {
			throw new SQLException("�ش��ϴ� ȸ�� ���̵� �����ϴ�.");
		}
		return dto;
	}

	@Override
	public String myResidence(String id) throws SQLException {
		return dao.myResidence(id);		
		
	}

	@Override
	public String checkSecurity(int residence) throws SQLException {
		int policeNo = dao.checkSecurity(residence);
		String securityGrade = null;
		if(policeNo >= 500) {
			securityGrade = "A";
		}else if(policeNo < 500 && policeNo >= 450) {
			securityGrade = "B";
		}else if(policeNo < 450 && policeNo >= 400) {
			securityGrade = "C";
		}else if(policeNo < 400) {
			securityGrade = "D";
		}
	
		return securityGrade;
	}

	@Override
	public int changeResidence(String id, int residence) throws SQLException {
		int result = dao.changeResidence(id, residence);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
		
		return result;
		
	}

	@Override
	public String checkDetail(String id) throws SQLException {
		return null;
		
	}



}
