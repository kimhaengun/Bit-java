package com.bit;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target = " java DB web framework ";
		
		// 문자열 앞, 뒤 의 공백 제거 = trim
		// ex) 회원가입이나 로그인 시 받은 데이터에 앞, 뒤 공백 없애 줘야함.
		System.out.println(" ->" + target.trim() + "<- ");
		
		//지정한 조건에 따라 문자열을 자름 = split
		//자른 문자열은 배열에 담기
		String[] arr1 = target.split(" ");		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		/*
		String target = "24148|강원도|화천군";
		
		// 문자열 앞, 뒤 의 공백 제거 = trim
		// ex) 회원가입이나 로그인 시 받은 데이터에 앞, 뒤 공백 없애 줘야함.
		System.out.println(" ->" + target.trim() + "<- ");
		
		//지정한 조건에 따라 문자열을 자름 = split
		//자른 문자열은 배열에 담기
		String[] arr1 = target.split("\\|");		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		*/
		
		String str1 = "java";
		String str2 = "javb";
		System.out.println(str1==str2);
		// 비교 문자가 같은지 비교 / 글자의 길이, 문자간의 차이
		// 0 = true,  false = 얼마나 차이나는지? 출력 
		System.out.println(str1.compareTo(str2));
		
	}

}
