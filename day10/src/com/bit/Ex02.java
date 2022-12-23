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
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("===학생성적관리프로그램(0.2.0)===");
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		int[][] data = new int[input][];
		int cnt=0;
		
		while(true) {
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >");
			input = sc.nextInt();
			if(input==0) break;
			if(input==1) {
				//리스트
				System.out.println("리스트");
				System.out.println("========================");
				System.out.println("학번\tjava\tweb\tframework");
				System.out.println("========================");
				for (int i = 0; i < data.length; i++) {
					int[] stu = data[i];
					if(stu==null) break;
					System.out.println(stu[0]+"\t"+stu[1]+"\t"+stu[2]+"\t"+stu[3]+"\t");
				}
				System.out.println("========================");
			}
			if(input==2) {
				//입력
				int[][] before = data;
				data = new int[data.length+1][];
				System.arraycopy(before, 0, data, 0, before.length);  // before --> data
				int[] stu = new int[4];
				stu[0]=inputSu("학번 > ");
				stu[1]=inputSu("java > ",100);
				stu[2]=inputSu("web > ",100);
				stu[3]=inputSu("framework > ",100);
				data[cnt++]=stu;
//				String[] msg = {"학번 > ","java > ","web > ","framework > "};
//				for (int i = 0; i < 4; i++) {
////					System.out.println(msg[i]);
////					input = sc.nextInt();
////					stu[i]=input;	
//				}

			}
			if(input==3) {
				//상세보기
				System.out.print("학번 > ");
				input = sc.nextInt();
				System.out.println(input + "학번의 합계, 평균, 학점");
				for (int i = 0; i < data.length; i++) {
					int[] stu = data[i];
					if(input==stu[0]) {
						System.out.println("합계 : "+(stu[1]+stu[2]+stu[3]));
						System.out.println("평균 : "+(stu[1]+stu[2]+stu[3])*100/3/100.0);
						char grade= 'F';
						if((stu[1]+stu[2]+stu[3]) >=3*90) grade = 'A';
						else if((stu[1]+stu[2]+stu[3]) >=3*80) grade = 'B';
						else if((stu[1]+stu[2]+stu[3]) >=3*70) grade = 'C';
						else if((stu[1]+stu[2]+stu[3]) >=3*60) grade = 'D';
						
						System.out.println("학점 : "+grade);
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
	public static int inputSu(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
//		int input = sc.nextInt();
		String input =sc.nextLine();
		int sum = 0;
		
			// 문자열 검사(숫자로만 구성되어 있는지 확인)
			boolean boo =true;
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i)<'0'|| input.charAt(i)>'9') {
					boo = false;
				}
			}
			if(boo) {
//			inputSu(msg); //boo = false 이면 재 입력
		    //숫자로 구성된 문자열을 숫자로 변환
			int m = 0;
			int n = 1;
			
			for (int i = input.length()-1; i >= 0; i--) {
				//숫자로변환 = input.charAt(i)-'0'
				
				for(int j = 0; j<m;j++) {
					n*=10;
				}
				sum+=(input.charAt(i)-'0')*n;
				n=1;
				m++;
				}		
		
			return sum;
		}else {
			return inputSu(msg);
		}	
	}
	public static int inputSu(String msg, int limit) {
		int su = -1;
		while(true) {
			su = inputSu(msg);
			if(su<0 ||su>limit) {
				continue;
			}else {
				return su;
			}	
		}
		
	}
}
