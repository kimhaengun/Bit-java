package com.bit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student{
	int studentNum, korScore, engScore, matScore;
	public Student() {
		
	}
	public Student(Student student) {
		// TODO Auto-generated constructor stub
		studentNum = student.studentNum;
		korScore = student.korScore;
		engScore = student.engScore;
		matScore = student.matScore;
	}

	
}
public class Ex14 {
	public static void main(String[] args) {
		//학생성적관리프로그램(ver 0.4.0)자료 구조
		// 1.리스트(목록) 2.입력 3.수정  4.삭제 5.상세보기 0.종료 >
		// 국어 영어 수학
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		System.out.println("===학생성적관리프로그램(ver 0.4.0)");
		
		boolean boo = true;
		do {
			//문자열 잡기 try~catch
			try {
				System.out.print("1.리스트  2.입력  3.수정  4.삭제  5.상세보기  0.종료 > ");
				Scanner sc = new Scanner(System.in);
				int inputNum = sc.nextInt();
				int selectIndex = -1;
				int sum = 0;
				double avg ;
				double allAvg;
				char grade;
				Student student;
				switch (inputNum) {
				case 1: //리스트
//					System.out.println("리스트");
					for (int i = 0; i < studentList.size(); i++) {
						System.out.print("학번  :"+studentList.get(i).studentNum + " 국어 :"+studentList.get(i).korScore+ " 영어 :"+studentList.get(i).engScore+" 수학 :"+studentList.get(i).matScore);
						System.out.println();
					}
					break;
				case 2: //입력
//					System.out.println("입력");

						System.out.print("학번  > ");
						inputNum = sc.nextInt();
						
						for (int i = 0; i < studentList.size(); i++) {
							if(inputNum == studentList.get(i).studentNum) {
								System.out.println("동일한 학번이 있습니다.");
								
							}
						}
						
						student = new Student();
						student.studentNum = inputNum;
						
						System.out.print("국어  > ");
						student.korScore = sc.nextInt();
						
						System.out.print("영어  > ");
						student.engScore = sc.nextInt();
						
						System.out.print("수학  > ");
						student.matScore = sc.nextInt();
						
						studentList.add(student);

						
					break;
				case 3: //수정
					//없는 번호 입력 try~catch
					try {
						System.out.print("수정 학번 > ");
						inputNum = sc.nextInt();
						for (int i = 0; i < studentList.size(); i++) {
							if(inputNum == studentList.get(i).studentNum) {
								selectIndex = i;
							}else {
								System.out.println("없는 학번 입니다.");
								break;
							}
						}
						System.out.println("=현재 학번 점수=");
						System.out.println("국어 : "+studentList.get(selectIndex).korScore);
						System.out.println("영어 : "+studentList.get(selectIndex).engScore);
						System.out.println("수학 : "+studentList.get(selectIndex).matScore);
						System.out.println("=수정 과목 선택=");
						System.out.print("1.국어  2.영어  3.수학  > ");
						inputNum =sc.nextInt();
						switch (inputNum) {
							case 1:
									student = new Student( studentList.get(selectIndex) );
									System.out.print("국어 > ");
									inputNum = sc.nextInt();
									student.korScore = inputNum;
									studentList.set(selectIndex, student);
									System.out.println("변경 완료 되었습니다.");
								break;
							case 2:
									student = new Student( studentList.get(selectIndex) );
									System.out.print("영어 > ");
									inputNum = sc.nextInt();
									student.engScore = inputNum;
									studentList.set(selectIndex, student);
									System.out.println("변경 완료 되었습니다.");
								break;
							case 3:
									student = new Student( studentList.get(selectIndex) );
									System.out.print("수학 > ");
									inputNum = sc.nextInt();
									student.matScore = inputNum;
									studentList.set(selectIndex, student);
								System.out.println("변경 완료 되었습니다.");
								break;
							default:
								System.out.println("번호를 다시확인하여 주세요  1~3숫자 입니다.");
								break;
						}
					} catch (IndexOutOfBoundsException e) {
						// TODO: handle exception
						System.out.println("없는 학번입니다.");
					}
					
					
					break;
				case 4: //삭제
					System.out.print("학번 > ");
					inputNum = sc.nextInt();
					//없는 번호 입력 try~catch
					try {
						for (int i = 0; i < studentList.size(); i++) {
							if(inputNum == studentList.get(i).studentNum) {
								selectIndex = i;
							}
						}
						
						
						System.out.println(studentList.remove(selectIndex));
						System.out.println("삭제 완료");
					} catch (IndexOutOfBoundsException e) {
						System.out.println("없는 학번입니다.");
					}
					
					
					break;
				case 5: //상세보기
					System.out.print("학번 > ");
					inputNum = sc.nextInt();
					//없는 번호 입력 try~catch
					try {
						for (int i = 0; i < studentList.size(); i++) {
							if(inputNum == studentList.get(i).studentNum) {
								selectIndex = i;
							}
						}
						
						System.out.println("국어 : "+studentList.get(selectIndex).korScore);
						System.out.println("영어 : "+studentList.get(selectIndex).engScore);
						System.out.println("수학 : "+studentList.get(selectIndex).matScore);
						
						//합계 and 평균
						sum = studentList.get(selectIndex).korScore+studentList.get(selectIndex).engScore+studentList.get(selectIndex).matScore;
						avg = (sum*100/3/100.0);
						//전체 평균
						int allKorScore = 0, allEngScore = 0, allmMatScore = 0;
						for (int i = 0; i < studentList.size(); i++) {
							allKorScore+=studentList.get(i).korScore;
							allEngScore+=studentList.get(i).engScore;
							allmMatScore+=studentList.get(i).matScore;
						}
						int allSubjectSum = allKorScore+allEngScore+allmMatScore;
						double allSubjectAvg = (allSubjectSum*100/3/studentList.size()/100.0);
						
						
						
						System.out.print("합계 : "+sum+"  평균/전체 평균("+avg+"/"+allSubjectAvg+")");
						
						
						//학점
						avg = (int)avg/10;
						grade = 0;
						switch ((int)avg) {
							case 10:
							
								break;
							case 9:
								grade='A';
								break;
							case 8:
								grade='B';	
								break;
							case 7:
								grade='C';
								break;
							case 6:
								grade='D';
								break;
							default:
								grade='F';
								break;
							}
							System.out.print(" 학점 : "+grade);
						
							System.out.println();
										
					} catch (IndexOutOfBoundsException e) {
						// TODO: handle exception
						System.out.println("없는 학번입니다.");
					}
					break;	
				case 0:
					System.out.println("시스템이 종료되었습니다.");
					boo = false;
					break;	
				default:
					System.out.println("0~5번호를 입력해 주세요!!!!");
					break;
				}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("숫자가 아닙니다.");
			}

		}while(boo);
		
	}
}
