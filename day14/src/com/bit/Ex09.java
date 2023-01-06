package com.bit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Student2 implements Comparable<Student2>{
	int num;
	int kor, eng, math;
	@Override
	public int compareTo(Student2 o) {
		// TODO Auto-generated method stub
		return  num-o.num;
//		return o.num-num;
	}
}
public class Ex09 {
	public static void main(String[] args) {
		Set<Student2> data = new TreeSet<Student2>(); //중복과 정렬 강점!! = TreeSet
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
				System.out.println("============================");
				System.out.println("학번   국어   영어   수학");
				System.out.println("============================");
				Iterator<Student2> ite = data.iterator();
				while(ite.hasNext()) {
					Student2 stu = ite.next();
					System.out.print(stu.num+"   ");
					System.out.print(stu.kor+"   ");
					System.out.print(stu.eng+"   ");
					System.out.println(stu.math+"   ");
				}
				System.out.println("============================");
			}else if(input==2) {
				System.out.println("보기");				
			}else if(input==3) {
				Student2 student = new Student2();
				System.out.print("학번>");
				student.num = sc.nextInt();
				System.out.print("국어>");
				student.kor = sc.nextInt();
				System.out.print("영어>");
				student.eng = sc.nextInt();
				System.out.print("수학>");
				student.math = sc.nextInt();
				data.add(student);
			}else if(input==4) {
				System.out.print("학번 >");
				input = sc.nextInt();
				Iterator<Student2> ite = data.iterator();
				while(ite.hasNext()) {
					Student2 stu2 = ite.next();
					if(stu2.num ==input) {
						data.remove(stu2);
						break;
					}
				}
				
				
			}else {
				System.out.println("입력 메뉴를 다시 확인하세요.");
			}
		}
		System.out.println("이용해 주셔서 감사합니다.");
	}
}
