package com.bit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Ex10 {
	public static void main(String[] args) {
		Map<Integer,Map<String,Integer>> data;
		data = new HashMap<Integer, Map<String,Integer>>();
		
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
				System.out.println("========================================");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("========================================");
				Set<Entry<Integer, Map<String, Integer>>> entrys = data.entrySet();
				Iterator<Entry<Integer, Map<String, Integer>>> ite = entrys.iterator();
				ite = entrys.iterator();
				while(ite.hasNext()) {
					Entry<Integer, Map<String, Integer>> entry;
					entry = ite.next();
					System.out.print(entry.getKey()+"\t");
					Map<String, Integer> stu = entry.getValue();
					System.out.print(stu.get("kor")+"\t");
					System.out.print(stu.get("eng")+"\t");
					System.out.println(stu.get("math")+"\t");
					
				}
				
				
				System.out.println("========================================");
			}else if(input==2) {
				System.out.print("학번 > ");
				input = sc.nextInt();
				Map<String, Integer> stu = data.get(input);
				System.out.print(stu.get("kor")+"\t");
				System.out.print(stu.get("eng")+"\t");
				System.out.println(stu.get("math")+"\t");
				
				
			}else if(input==3) {
				System.out.print("학번 >");
				int num = sc.nextInt();
				
				Map<String, Integer> stu;
				stu = new HashMap<String, Integer>();
				
				System.out.print("국어 >");
				stu.put("kor", sc.nextInt());
				System.out.print("영어 >");
				stu.put("eng", sc.nextInt());
				System.out.print("수학 >");
				stu.put("math", sc.nextInt());
				
				data.put(num,stu);
			}else if(input==4) {
				System.out.print("학번 > ");
				input = sc.nextInt();
				data.remove(input);
				
				
			}else {
				System.out.println("입력 메뉴를 다시 확인하세요.");
			}
		}
		System.out.println("이용해 주셔서 감사합니다.");
	}
}
