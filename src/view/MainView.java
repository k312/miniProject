package view;

import java.util.Scanner;

import Controller.UserController;
import DTO.UserDTO;

public class MainView {
	
	Scanner scn = new Scanner(System.in);
	
	UserController controller = new UserController(); //��Ʈ�ѷ� ����;
	
	public MainView() {
		
		String choice = null;
		
		do {
			System.out.println("**ġ�� �˻� �ý��ۿ� �����ϽŰ��� ȯ���մϴ�~**");
			System.out.print("1. �α���		2. ȸ������");
			choice = scn.next();

			switch (choice) {
			case "1":
				login(); 
				break;

			case "2":
				signup();
				break;
				
			default :
				System.out.println("1�� �ƴϸ� 2���� �Է����ּ���");
			}
		}while(choice != "1" || choice != "2");

		
	}
	
	public void login() {
		
		System.out.println();
		System.out.println("*****�α��� ȭ��*****");
		System.out.print("ID : ");
		String id = scn.next();
		System.out.print("PW : ");
		String password = scn.next();
		
		/**
		 * �׸��� ��Ʈ�ѷ� �θ���
		 * */
		UserDTO info = controller.logIn(id, password);
				
		if(info != null) {
			this.serviceCoice(id);
		}

		
	}
	
	public void signup() {
		
		System.out.println();
		System.out.println("*****ȸ������ ȭ��*****");
		System.out.print("���ϴ� ID�� �Է����ּ��� : ");
		String id = scn.next();
		System.out.print("���Ͻô� PW�� �Է����ּ���. : ");
		String password = scn.next();
		System.out.print("�������� ��ȣ�� �Է����ּ���. : ");
		System.out.println("1.���� ");
		System.out.println("2.�λ� ");
		System.out.println("3.�뱸 ");
		System.out.println("4.��õ ");
		System.out.println("5.���� ");
		System.out.println("6.���� ");
		System.out.println("7.��� ");
		System.out.println("8.��Ⳳ�� ");
		System.out.println("9.���Ϻ� ");
		System.out.println("10.���� ");
		System.out.println("11.��� ");
		System.out.println("12.�泲 ");
		System.out.println("13.���� ");
		System.out.println("14.���� ");
		System.out.println("15.��� ");
		System.out.println("16.�泲 ");
		System.out.println("17.���� ");
		String res = scn.next();

		/**
		 * �׸��� ��Ʈ�ѷ� �θ���
		 *signUp
		 * */
		
		this.serviceCoice(id);
		
	}
	
	public void serviceCoice(String id) {
		System.out.println(id+"�� ȯ���մϴ�!");
		
		System.out.println("1. �� ������ Ȯ���ϱ�");
		System.out.println("2. ������ ġ�� ��� Ȯ��");
		System.out.println("3. ���� �Ű��ϱ�(������ ����)");
		System.out.println("4. ġ�� ���� ������ ����");
		System.out.println("5. ���α׷� ����");
		String choice = scn.next();
		
		switch (choice) {
		case "1":
			//�� ������ Ȯ���ϱ�
			break;

		case "2":
			//������ ġ�� ��� Ȯ��
			break;

		case "3":
			//���� �Ű��ϱ�(������ ����)
			break;
			
		case "4":
			//ġ�� ���� ������ ����
			break;
			
		case "5":
			//���α׷� ����
			break;
		}
		
		printQuestion();
		String ch = scn.next();
		
		switch (ch) {
		case "1":
			//�ʱ�ȭ������ ���ư���
			break;

		case "2":
			//����
			break;
		}
		
		
	}
	
	public void printQuestion() {
		System.out.println("�ʱ�ȭ������ ���ư���� 1��");
		System.out.println("����� 2���� �����ּ���.");
	}

}
