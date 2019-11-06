package Controller;

import java.sql.SQLException;

import DTO.UserDTO;
import service.UserService;
import service.UserServiceImpl;
import view.FailView;
import view.SuccessView;

public class UserController {
	private UserService service = new UserServiceImpl();
	

	public UserDTO signUp(String id, String password, int residence){
		UserDTO dto = null;
		
		try{
			dto = service.signUp(id, password, residence);
			SuccessView.printMessage("회원가입이 성공적으로 완료되었습니다.");
		}catch (SQLException e) {
			FailView.printFailMessage(e.getMessage());
		}
		
		return dto;
	}


	
	public UserDTO logIn(String id, String password) {
		UserDTO dto = service.logIn(id, password);
		
		try{
			dto = service.logIn(id, password);
			SuccessView.printMessage("로그인 되었습니다.");
		}catch (SQLException e) {
			FailView.printFailMessage(e.getMessage());
		}
		
		return dto;
	}


	public String myResidence(String id){
		return service.myResidence(id);
		
	}


	public String checkSecurity(int residence){
		String securityGrade = null;
		
		try {
			securityGrade = service.checkSecurity(residence);
			SuccessView.printMessage(securityGrade);
		}catch (SQLException e) {
			FailView.printFailMessage(e.getMessage());
		}
		
		return securityGrade;
	}


	public int changeResidence(String id, int residence){
		int result = 0;
		
		try {
			result = service.changeResidence(id, residence);
			SuccessView.printMessage("전출 신고가 완료되었습니다.");
			}catch (SQLException e) {
				FailView.printFailMessage(e.getMessage());
			}
			
		return result;
		
	}

	public String checkDetail(String id){
		return null;
		
	}
	
}
