package com.bit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Student{
	int korScore, engScore, matScore;

}
public class Ex020 {
	public static void main(String[] args) {
		System.out.println("===학생성적관리프로그램===");
		boolean boo =true;
		int input = 0 ;
		int studentNum=0;
		Map studentMap = new HashMap();
		
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("1.학생 목록    2.입력   3.수정   4.삭제   5.상세보기   0.종료 > ");
				input = sc.nextInt();
//				System.out.println(studentMap.size());
				switch (input) {
				
					case 1: //목록
//						System.out.println("목록");
//						System.out.println(studentMap.size());
						Set keys = studentMap.keySet();
						Iterator ite = keys.iterator(); //key 1,
//						System.out.println("??"+keys);
						while(ite.hasNext()) {
//							System.out.println("iter 돔?");
							Object key = ite.next();
							System.out.println("학번 :"+key
									+" 국어:"+((Student)studentMap.get(key)).korScore
									+" 영어:"+((Student)studentMap.get(key)).engScore
									+" 수학:"+((Student)studentMap.get(key)).matScore);
						}
						
//						Collection list = studentMap.values();
//						Iterator ite = list.iterator();
//						while(ite.hasNext()) {
//							System.out.println(ite.next());
//						}
						break;
					case 2: //입력
						Student student = new Student();
						
						System.out.print("학번 > ");
						studentNum = sc.nextInt();
						
						System.out.print("국어 > ");
						input = sc.nextInt();
						student.korScore = input;
						
						System.out.print("영어 > ");
						input = sc.nextInt();
						student.engScore = input;
						
						System.out.print("수학 > ");
						input = sc.nextInt();
						student.matScore = input;
						
						studentMap.put(studentNum, student);
						
//						System.out.println(((Student)studentMap.get(studentNum)).engScore);
						
						break;
					case 3: //수정
						System.out.print("학번 >");
						input = sc.nextInt();
						try {
							studentSubjectInfo(studentMap, input);
							
							System.out.print("수정할 과목 선택 1.국어   2.영어   3.수학   0.종료 > ");
							input = sc.nextInt();
							switch (input) {
								case 1:
									System.out.print("국어 > ");
									int korUpdate = sc.nextInt();
									((Student)studentMap.get(input)).korScore=korUpdate;
									break;
								case 2:
									System.out.print("영어 > ");
									int engUpdate = sc.nextInt();
									((Student)studentMap.get(input)).engScore=engUpdate;
									break;
								case 3:
									System.out.print("수학 > ");
									int matUpdate = sc.nextInt();
									((Student)studentMap.get(input)).matScore=matUpdate;
									break;
								case 0:
									
									break;
								default:
									System.out.println("1~3 번호를 입력해 주세요");
									break;
							}
							
						} catch (NullPointerException e) {
							System.out.println("없는 학번입니다.");
							break;
						}

						break;
					case 4: //삭제
						System.out.print("학번 > ");
						input=sc.nextInt();
						
							if(studentMap.get(input)==null) {
								System.out.println("없는 학번 입니다.");
							}else {
								studentMap.remove(input);
								System.out.println("학번 :"+input+"이 삭제 되었습니다.");
								
							}
			
						break;
					case 5: //상세보기
						char grade;
						System.out.print("학번 >");
						input = sc.nextInt();
						try {
							studentSubjectInfo(studentMap, input);

							
							int sum = ((Student)studentMap.get(input)).korScore+((Student)studentMap.get(input)).engScore+((Student)studentMap.get(input)).matScore;
							double avg = (sum*100/3/100.0);
							System.out.print("합계 :"+sum+ " 평균:"+avg);
							
							int gradeAvg = (int)avg;
							
							if(100>=gradeAvg&&gradeAvg>=90) {
								grade='A';
							}else if(90>gradeAvg&&gradeAvg>=80){
								grade='B';
							}else if(80>gradeAvg&&gradeAvg>=70){
								grade='C';
							}else if(70>gradeAvg&&gradeAvg>=60){
								grade='D';
							}else {
								grade='F';
							}
							System.out.print(" 학점:"+grade);
							System.out.println();
						} catch (NullPointerException e) {
							System.out.println("없는 학번입니다.");
							break;
						}
						break;
					case 0: //종료
						System.out.println("종료");
						boo = false;
						break;	
					default:
						System.out.println("0~5 번 숫자로 입력해 주세요");
						break;
				}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("숫자를 입력해주세요");
				continue;
			}
			
		}while(boo);
	}

	public static void studentSubjectInfo(Map studentMap, int input) {
		// TODO Auto-generated method stub
		System.out.println("국어:"+((Student)studentMap.get(input)).korScore);
		System.out.println("영어:"+((Student)studentMap.get(input)).engScore);
		System.out.println("수학:"+((Student)studentMap.get(input)).matScore);
	}

}
