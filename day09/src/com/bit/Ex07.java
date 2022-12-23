package com.bit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 		//학생성적관리프로그램(0.2.0)
		//교과목 - java, web, framework
		//1.리스트 2.입력 3.상세보기 4.삭제  0.종료 >
		// 1.리스트에서 데이터만 - 학번, java, web, framework
		// 3.상세보기 - 각 학점, 합계, 학생평균/전체평균  학점[5]
		///////////////////////////////////////////////////////////
		//  1. 수업내용 내 동적할당[20]  2.수업외 동적할당[15]
		//  3. 시작시 총인원 입력 받기[10] 4.기타[5]
		//  [10] 합계 :  평균 :(해당 학생의 평균/전체평균 = 소수 둘째자리)  학점 :
		// 제출양식(10), 안지칠 시 각항목당-2
		// 제출양식 1. 소스코드
		//       2. 양식에 맞춰서
		//       3.각 메뉴별 결과 스샷
		//       4.1차평가_홍길동.doc
		//    4시반까지!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

 * 
 * 
 */
class Student{
	int studentNum;
	int javaNum;
	int webNum;
	int frameworkNum;
}
public class Ex07 {
	public static void main(String[] args) {
		
		boolean boo = true;	
		ArrayList<Student> studentList = new ArrayList<Student>();
		//과목
		String studentstr="학번", javastr="java", webstr="web", frameworkstr="framework";
		//입력 받을 데이터
		
		
		
		do {
			System.out.println("\n===학생성적관리프로그램(0.2.0)===");
			System.out.println("교과목 - java, web, framework");
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제 0.종료 > ");
			Scanner sc = new Scanner(System.in);
			int inputNum = sc.nextInt();
//			System.out.println("입력받은 데이터 : "+inputNum);

			switch (inputNum) {
			case 1:// 리스트
				System.out.println("학생리스트");
				int numInd=1;
				for (int i = 0; i < studentList.size(); i++) {
					
					System.out.print(numInd+". ");
					System.out.print(studentstr+": "+studentList.get(i).studentNum+"  ");
					System.out.print(javastr+": "+studentList.get(i).javaNum+"  ");
					System.out.print(webstr+": "+studentList.get(i).webNum+"  ");
					System.out.print(frameworkstr+": "+studentList.get(i).frameworkNum+"  ");
					numInd++;
					System.out.println();
				}
				break;
			case 2: //입력
				Student student = new Student();
				System.out.println("학생 입력 !!");
				System.out.print(studentstr+": ");
				student.studentNum = sc.nextInt();
				
				System.out.print(javastr+": ");
				student.javaNum = sc.nextInt();
				
				System.out.print(webstr+": ");
				student.webNum = sc.nextInt();
				
				System.out.print(frameworkstr+": ");
				student.frameworkNum=sc.nextInt();
				
//				System.out.println("학번 : "+student.studentNum+" java: "+student.javaNum+" web: "+student.webNum+" framework: "+student.frameworkNum);
				studentList.add(student);
//					System.out.println(student.javaNum);
//					System.out.println(studentList.get(0).javaNum);
				break;
			case 3: //상세보기
				System.out.println("학생 상세보기");
				System.out.print("학번 입력 : ");
				int inputStudentNum = sc.nextInt();
				int indNum = 0;
				//ex)학번 : 2017의 index찾기
				for (int i = 0; i < studentList.size(); i++) {
					if(inputStudentNum==studentList.get(i).studentNum) {
						//해당 값의 index
						indNum = i;
						System.out.println("인덱스 번호 : "+i);
					}
				}
				
				// 각 과목, 합계, 평균, 전체 평균, 학점 출력
				for (int j = 0; j < 1; j++) {
					int sum = 0;
					int studentJavaNum = studentList.get(indNum).javaNum;
					int studentWebNum = studentList.get(indNum).webNum;
					int studentFrameworkNum = studentList.get(indNum).frameworkNum;
					//각 과목의 점수 출력
					System.out.println(javastr+": "+studentJavaNum);
					System.out.println(webstr+": "+studentWebNum);
					System.out.println(frameworkstr+": "+studentFrameworkNum);
					
					//학생 합계 구하기
					sum = studentJavaNum+studentWebNum+studentFrameworkNum;
					System.out.print("합계 :"+sum);
					
					//학생 평균 구하기
					double douAvg = (double)sum/3;
//					System.out.println(douAvg);
					int inAvg = (int) (douAvg*100);
//					System.out.println("inAvg:"+inAvg);
					double avg = (double)inAvg/100;
					
					
					
					
					int javaSum = 0, webSum =0, frameworkSum =0;
					
					for (int i = 0; i < studentList.size(); i++) {
						javaSum+=studentList.get(i).javaNum;
						webSum += studentList.get(i).webNum;
						frameworkSum+=studentList.get(i).frameworkNum;
						
					}
					int subjectSum = javaSum+webSum+frameworkSum;
					double subjectSumAvg = (double)subjectSum/3;
					double subjectSumStudentCountAvg = subjectSumAvg/studentList.size();
					
					
					System.out.print("  평균("+avg+"/"+subjectSumStudentCountAvg+")");
					
					//56.66
					//학점 구하기
					avg = (int)avg/10;
					char grade = 0;
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
						if(grade=='F') {
							System.out.print("  학점  :"+grade);
						}else {
							System.out.print("  학점 : "+grade);
						}
					
				}
				
				System.out.println();
				break;
			case 4: //삭제
				System.out.println("학생 삭제");
				System.out.print("학번 입력 : ");
				int deleteStudentNum = sc.nextInt();
				int deleteIndexNum = 0;
				//학번 index 구하기
				for (int i = 0; i < studentList.size(); i++) {
					if(deleteStudentNum==studentList.get(i).studentNum) {
						//해당 값의 index
						deleteIndexNum = i;
//						System.out.println("삭제 인덱스 번호 : "+deleteIndexNum);
					}
				}
				
				studentList.remove(deleteIndexNum);
				
				System.out.println("학번 : "+deleteStudentNum+"이 삭제 완료되었습니다.");
				break;
			case 0: //종료
				System.out.println("종료 되었습니다.");
				boo = false;
				break;
			default:
				System.out.println("잘못 입력 하셨습니다. 입력 숫자(0~4)");
				break;
			}			
			
		}
		while(boo) ;
		
	}
}
