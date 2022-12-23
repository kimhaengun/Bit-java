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
public class Ex01 {
	public static void main(String[] args) {
		System.out.println("===학생성적관리프로그램(0.2.0)===");
		Scanner sc = new Scanner(System.in);
		int input = 0;
//		System.out.print("총원 > ");
//		input = sc.nextInt();
		int[] data = new int[input*4]; //배열 크기 = 4의 배수 = 4개 값이 들어감
		int cnt = 0;
		while(true) {
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >");
			input = sc.nextInt();
			if(input==0) break;
			if(input==1) {
				//리스트
				System.out.println("========================");
				System.out.println("학번\tjava\tweb\tframework");
				System.out.println("========================");
				for (int i = 0; i < data.length; i++) {
					System.out.print(data[i++]);
					System.out.print('\t');
					
					System.out.print(data[i++]);
					System.out.print('\t');
					
					System.out.print(data[i++]);
					System.out.print('\t');
					
					System.out.print(data[i]);
					System.out.print('\n');
				}
				System.out.println("========================");
			}
			if(input==2) {
				//입력
//				if(cnt == data.length) {
//					System.out.println("총원 초과 입니다.");
//					continue;  //총원보다 많이 학생을 입력할 경우 if문 맨위로 (Exception 처리)
//				}
				int[] before = data;
				data = new int[data.length+4];
				System.arraycopy(before, 0, data, 0, before.length);
				
				System.out.print("학번 > ");
				input = sc.nextInt();
				data[cnt++] = input;
				
				System.out.print("java > ");
				input = sc.nextInt();
				data[cnt++] = input;
				
				System.out.print("web > ");
				input = sc.nextInt();
				data[cnt++] = input;
				
				System.out.print("framework");
				input = sc.nextInt();
				data[cnt++] = input;
				
			}else
			if(input==3) {
				//상세보기
				System.out.print("학번 > ");
				input = sc.nextInt();
				for (int i = 0; i < data.length; i+=4) {
					if(input==data[i]) {
						int sum=data[++i]+data[++i]+data[++i];
						double avg = sum*100/3/100.0;
						char grade ='F';
						if(sum >= 3*90) grade = 'A';
						else if(sum>=3*80) grade = 'B';
						else if(sum>=3*70) grade = 'C';
						else if(sum>=3*60) grade = 'D';
						System.out.println(input+"학번 합계: "+sum);
						System.out.println(input+"학번 평균: "+avg);
						System.out.println(input+"학번 학점: "+grade);
						break;
					}
				}
			
				
			}
			if(input==4) {
				//삭제
				System.out.println("삭제");
			}
		}

		
		
	}
}
