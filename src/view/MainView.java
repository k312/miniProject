package view;

import java.util.Scanner;

import Controller.UserController;
import DTO.UserDTO;

public class MainView {
	
	Scanner scn = new Scanner(System.in);
	
	UserController controller = new UserController(); //컨트롤러 생성;
	
	UserDTO account;
	
	public MainView() {
		
		String choice = null;
		
		do {
			System.out.println();
			System.out.println("**치안 검색 시스템에 접속하신것을 환영합니다~**");
			System.out.println("1. 로그인		2. 회원가입");
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
		account = controller.logIn(id, password);
				
		if(account != null) {
			this.serviceCoice(id);
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
		int res = scn.nextInt();

		/**
		 * 그리고 컨트롤러 부르기
		 *signUp
		 * */
		controller.signUp(id, password, res);
		
		
		this.serviceCoice(id);
		
	}
	
	public void serviceCoice(String id) {
		
		while(true) {
			System.out.println();
			System.out.println(id+"님 환영합니다!");
			
			System.out.println("1. 내 거주지 확인하기");
			System.out.println("2. 거주지 치안 등급 확인");
			System.out.println("3. 전출 신고하기(거주지 변경)");
			System.out.println("4. 치안 관련 데이터 수정");
			System.out.println("5. 프로그램 종료");
			String choice = scn.next();
			
			switch (choice) {
			case "1":
				//내 거주지 확인하기
				controller.myResidence(id);
				break;

			case "2":
				//거주지 치안 등급 확인
				controller.checkSecurity(account.getResidence());
				break;

			case "3":
				//전출 신고하기(거주지 변경)
				controller.changeResidence(account.getId(), account.getResidence());
				break;
				
			case "4":
				//치안 관련 데이터 수정
				System.out.println("실수 ㅎㅎ");
				break;
				
			case "5":
				//프로그램 종료
				System.exit(0);
				break;
			}
			
			printQuestion();
			String ch = scn.next();
			
			switch (ch) {
			case "1":
				//초기화면으로 돌아가기
				break;

			case "2":
				//종료
				System.out.println();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
		
		
		
	}
	
	public void printQuestion() {
		System.out.println("초기화면으로 돌아가기는 1번");
		System.out.println("종료는 2번을 눌러주세요.");
	}

}
