package view;

import DTO.UserDTO;

public class SuccessView {
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static void printQuestion() {
		System.out.println("초기화면으로 돌아가기는 1번");
		System.out.println("종료는 2번을 눌러주세요.");
	}
	
	public static void printUserInfo(UserDTO dto) {
		System.out.println(dto);
	}
	
}
