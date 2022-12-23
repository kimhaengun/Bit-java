package com.bit;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램 ver 0.3.0");
		Scanner sc = new Scanner(System.in);
		int inputNum = -1;
		Arr data = new Arr();
		while(true) {
			System.out.print("1.목록 2.상세보기 3.입력 4.삭제 0.종료 > ");
			inputNum = sc.nextInt();
			if(inputNum == 0) {
				break;
			}else if(inputNum==1) {
				System.out.println("학생 목록");
				System.out.println("학번\t국어\t영어\t수학");
				for (int i = 0; i < data.size(); i++) {
					int[] stu = (int[])data.get(i);
					
					System.out.print(stu[0]+"\t");
					System.out.print(stu[1]+"\t");
					System.out.print(stu[2]+"\t");
					System.out.print(stu[3]+"\n");
				}
				
			}else if(inputNum==2) {
				System.out.println("상세보기");
				System.out.println("학번 > ");
				inputNum = sc.nextInt();
				for (int i = 0; i < data.size(); i++) {
					int[] stu = (int[])data.get(i);
					if(inputNum == stu[0]) {
						System.out.println("합계"+(stu[1]+stu[2]+stu[3]));
					}
				}
			}else if(inputNum==3) {
				//stu 배열 생성
				int[] stu = new int[4];
				
				System.out.print("학번 > ");
				inputNum = sc.nextInt();
				stu[0] = inputNum;
				
				System.out.print("국어 > ");
				inputNum = sc.nextInt();
				stu[1] = inputNum;
				
				System.out.print("영어 > ");
				inputNum = sc.nextInt();
				stu[2] = inputNum;
				
				System.out.print("수학 > ");
				inputNum = sc.nextInt();
				stu[3] = inputNum;
				data.add(stu);
				
			}else if(inputNum==4) {
				System.out.println("학번 > ");
				inputNum = sc.nextInt();
				for (int i = 0; i < data.size(); i++) {
					int[] stu = (int[])data.get(i);
					if(inputNum==stu[0]) {						
						data.remove(i);
						break;
					}
				}
			}
			
				
		}
		
		
	}
}
