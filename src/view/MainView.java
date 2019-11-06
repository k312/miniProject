package view;

import java.util.Scanner;

import DTO.UserDTO;

public class MainView {
	
	Scanner scn = new Scanner(System.in);
	
	public MainView() {
		
		String choice = null;
		
		do {
			System.out.println("**치안 검색 시스템에 접속하신것을 환영합니다~**");
			System.out.print("1. 로그인		2. 회원가입");
			choice = scn.next();

			switch (choice) {
			case "1":
				login(); 
				break;

			case "2":
				signup();
				break;
				
			default :
				System.out.println("1번 아니면 2번을 입력해주세요");
			}
		}while(choice != "1" || choice != "2");

		
	}
	
	public void login() {
		
		System.out.println();
		System.out.println("*****로그인 화면*****");
		System.out.print("ID : ");
		String id = scn.next();
		System.out.print("PW : ");
		String password = scn.next();
		
		/**
		 * 그리고 컨트롤러 부르기
		 * */
		UserDTO info =;
				
		if(info != null) {
			System.out.println(id+"님 환영합니다!");
		}

		
	}
	
	public void signup() {
		
		System.out.println();
		System.out.println("*****회원가입 화면*****");
		System.out.print("원하는 ID를 입력해주세요 : ");
		String id = scn.next();
		System.out.print("원하시는 PW를 입력해주세요. : ");
		String password = scn.next();
		System.out.print("거주지를 번호로 입력해주세요. : ");
		System.out.println("1.서울 ");
		System.out.println("2.부산 ");
		System.out.println("3.대구 ");
		System.out.println("4.인천 ");
		System.out.println("5.광주 ");
		System.out.println("6.대전 ");
		System.out.println("7.울산 ");
		System.out.println("8.경기남부 ");
		System.out.println("9.경기북부 ");
		System.out.println("10.강원 ");
		System.out.println("11.충북 ");
		System.out.println("12.충남 ");
		System.out.println("13.전북 ");
		System.out.println("14.전남 ");
		System.out.println("15.경북 ");
		System.out.println("16.경남 ");
		System.out.println("17.제주 ");
		String res = scn.next();

		/**
		 * 그리고 컨트롤러 부르기
		 * */
		
	}

}
