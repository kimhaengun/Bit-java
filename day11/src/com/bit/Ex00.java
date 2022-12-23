package com.bit;

import java.util.Scanner;

/*
  		//학생성적관리프로그램(0.2.0)
		//교과목 - java, web, framework
		//1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >
		// 1.리스트에서 데이터만 - 학번, java, web, framework
		// 3.상세보기 - 각 학점, 합계, 학생평균/전체평균  학점[5]
		/////////////////////////////////////////////////////////// 
 */
public class Ex00 {
	public static void main(String[] args) {
		System.out.println("===학생성적관리프로그램(0.2.0)===");
		Scanner sc = new Scanner(System.in);
		int input = 0;
//		System.out.print("총원 > ");
//		input = sc.nextInt();
		int[] data = new int[input*4]; //배열 크기 = 4의 배수 = 4개 값이 들어감
		int idxNum = 0;
		while(true) {
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >");
			input = sc.nextInt();
			if(input==0) break;
			if(input==1) {
				//리스트
				int idxNum1 = 1;
				for (int i = 0; i < data.length; i++) {
					System.out.print(idxNum1+". ");
					System.out.print("학번 : ");
					System.out.print(data[i++]);
					
					System.out.print(" java : ");
					System.out.print(data[i++]);
					
					
					System.out.print(" web : ");
					System.out.print(data[i++]);
					
					
					System.out.print(" framework : ");
					System.out.print(data[i]);
					System.out.print('\n');
					idxNum1++;
				}
				System.out.println("========================");
			}
			if(input==2) {
				//입력
				int[] copyArr = data;
				data = new int[data.length+4];
				System.arraycopy(copyArr, 0, data, 0, copyArr.length);
				
				System.out.print("학번 > ");
				input = sc.nextInt();
				data[idxNum++] = input;
				
				System.out.print("java > ");
				input = sc.nextInt();
				data[idxNum++] = input;
				
				System.out.print("web > ");
				input = sc.nextInt();
				data[idxNum++] = input;
				
				System.out.print("framework");
				input = sc.nextInt();
				data[idxNum++] = input;
				
			}else
			if(input==3) {
				//상세보기
				System.out.print("학번 > ");
				input = sc.nextInt();
				int line = 4;
				int sum = 0;
				
				for (int i = 0; i < data.length; i+=line) {
					if(input == data[i]) {
						 // 초기 : 0 1 2 3 / 4 5 6 7 / 8 9 10 11;
						for (int j = 0; j < 4; j++) {
							int idPlus ;
							sum+=data[i];
						}
						System.out.print("학번 : "+data[i++]+" java : "+data[i++]+" web : "+data[i++]+" framework : "+data[i++]);
						
						System.out.println("합계 : "+sum);
					}
					
				}
			
				System.out.println();
			
				
			}
			if(input==4) {
				//삭제
				System.out.println("삭제");
			}
		}

		
		
	}
}
