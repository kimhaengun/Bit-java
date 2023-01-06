package com.bit;

import java.util.Scanner;

public class Ex12 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램 ver 0.4.0");
		Scanner sc = new Scanner(System.in);
		int input = -1;
		while(true) {
			System.out.print("1.목록  2.보기  3.입력  4.삭제  0.종료 >");
			try { //숫자 안들어옴
				input = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자로 입력바합니다.");
				//한번 Scanner를 통해 오류가 발생하면 무한루프로 빠지기 때문에 새로운 Scanner 객체 생성
				sc = new Scanner(System.in);
				continue;
			}
			
			if(input==0) {
				break;
			}else if(input==1) {
				System.out.println("목록");
			}else if(input==2) {
				System.out.println("보기");				
			}else if(input==3) {
				System.out.println("입력");
			
			}else if(input==4) {
				System.out.println("삭제");
			}else {
				System.out.println("입력 메뉴를 다시 확인하세요.");
			}
		}
		System.out.println("이용해 주셔서 감사합니다.");
	}
}
