package view;

import DTO.UserDTO;

public class SuccessView {
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static void printQuestion() {
		System.out.println("�ʱ�ȭ������ ���ư���� 1��");
		System.out.println("����� 2���� �����ּ���.");
	}
	
	public static void printUserInfo(UserDTO dto) {
		System.out.println(dto);
	}
	
}
