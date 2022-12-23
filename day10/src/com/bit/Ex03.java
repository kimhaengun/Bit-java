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
class Stu{
	int stunum,java, web, framework;
	final String name;
	
	Stu(int stunum, String name){
		this.stunum = stunum;
		this.name = name;
	}
	int total() {
		return (java+web+framework);
	}
	double avg() {
		return total()*100/3/100.0;
	}
	char grade() {
		if(total()>=3*90) return 'A';
		if(total()>=3*80) return 'B';
		if(total()>=3*70) return 'C';
		if(total()>=3*60) return 'D';
		return 'F';
		
	}
}
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("===학생성적관리프로그램(0.2.0)===");
		Scanner sc = new Scanner(System.in);
		int input = 0;
		System.out.print("총원 > ");
		input = sc.nextInt();
		Stu[] data = new Stu[input];
		
		Scanner sc2 = new Scanner(System.in);
		
		int cnt = 0;
		while(true) {
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >");
			input = sc.nextInt();
			if(input==0) break;
			if(input==1) {
				//리스트
				System.out.println("리스트");
				System.out.println("========================");
				System.out.println("학번\t이름\tjava\tweb\tframework");
				for (int i = 0; i < data.length; i++) {
					Stu stu = data[i];
					if(stu==null)break;
					System.out.println(stu.stunum+"\t"+stu.name+"\t"+stu.java+"\t"+stu.web+"\t"+stu.framework);
				}
				System.out.println("========================");
			}
			if(input==2) {
				//입력
				Stu stu ;
				System.out.print("학번 > ");
				int stunum = sc.nextInt();
				System.out.print("이름 > ");
				String input2 = sc2.nextLine();
				stu = new Stu(stunum,input2);
				
				System.out.print("java > ");
				stu.java = sc.nextInt();
				System.out.print("web > ");
				stu.web = sc.nextInt();
				System.out.print("framework");
				stu.framework = sc.nextInt();
				data[cnt++]=stu;
			}
			if(input==3) {
				//상세보기
				System.out.print("학번 > ");
				input = sc.nextInt();
				for (int i = 0; i < data.length; i++) {
					Stu stu = data[i];
					if(stu.stunum==input) {
						System.out.print("합계 : "+stu.total());
						System.out.print("평균 : "+stu.avg());
						System.out.print("학점 : "+stu.grade());
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
