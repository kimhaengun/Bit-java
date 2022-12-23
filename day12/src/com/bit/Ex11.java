package com.bit;

public class Ex11 {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("java");
		sb1.append(1111);
		//문자열 끼워 넣기
		sb1.insert(4, "Web");
		sb1.insert(0, 2222); // = append
		
		//문자열 수정
		sb1.replace(4, 8, "JAVA"); // 시작, 끝, 원하는 문자열
		//삭제
		//1.
//		sb1.replace(4, 8, ""); // 시작, 끝, 원하는 문자열
		//2.
		sb1.delete(4, 8); // 시작, 끝
		
		System.out.println(sb1);
		//앞 뒤 변경
		sb1.reverse();
		System.out.println(sb1);
		
		
	}
}
