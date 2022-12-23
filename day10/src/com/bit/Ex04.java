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
public class Ex04 {
	
	//String input을 숫자로 바꿔주는 기능
	public static int inputSu(String input) {
		int sum = 0;
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
	}
	
	public static void main(String[] args) {
		System.out.println("===학생성적관리프로그램(0.2.0)===");
		Scanner sc = new Scanner(System.in);
		int input = 0;
		String data="";
		while(true) {
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >");
			input = sc.nextInt();
			
			if(input==0) break;
			if(input==1) {
				//리스트
				System.out.println("리스트");
				System.out.println("========================");
				System.out.println("학번\tjava\tweb\tframework");
				System.out.println(data);
				System.out.println("========================");
			}
			if(input==2) {
				//입력
				System.out.print("학번 > ");
				input = sc.nextInt();
				data+="\n"+input+"\t";
				
				System.out.print("java > ");
				input = sc.nextInt();
				data+=input+"\t";
				
				System.out.print("web > ");
				input = sc.nextInt();
				data+=input+"\t";
				
				System.out.print("framework > ");
				input = sc.nextInt();
				data+=input+"\t";
			}
			if(input==3) {
				//상세보기
				System.out.print("학번 > ");
				input = sc.nextInt();
//				int index=-1;
//				if(data.startsWith(input+"\t")) {
//					index=0;
//				}else {
//					index = data.indexOf("\n"+input+"\t")+1;
//					if(index==0) index=-1;
//				}
//				
//				if(index!=-1) {
					String[] arr1 = data.split("\n");
					for (int i = 0; i < arr1.length; i++) {
//						System.out.println(i+":"+arr1[i]);
						String[] arr2= arr1[i].split("\t");
						if(arr2[0].equals(input+"")) {
							int sum = inputSu(arr2[1])+inputSu(arr2[2])+inputSu(arr2[3]);
							System.out.println("합계 : "+sum);
						}
					}
//				}
				
//				if(index!=-1) {
//					int end = data.indexOf('\n',index);
//					String stu = data.substring(index, end);
//					String[] arr =stu.split("\t");
//					int sum = inputSu(arr[1])+inputSu(arr[2])+inputSu(arr[3]);
//					System.out.println("합계 : "+sum);
//					System.out.println("평균: "+(sum*100/3/100.0));
//					if(sum<=3*90) System.out.println("학점 A");
//					else if(sum<=3*80) System.out.println("학점 B");
//					else if(sum<=3*70) System.out.println("학점 C");
//					else if(sum<=3*60) System.out.println("학점 D");
//					else System.out.println("학점 F");	
//				}
				
				
			}
			if(input==4) {
				//삭제
				System.out.println("삭제");
			}
		}

		
		
	}
}
