package com.bit;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "abcABC1234!@#$";
		String str1 = msg.toUpperCase(); //모든 문자열 대문자
		String str2 = msg.toLowerCase(); //모든 문자열 소문자
		System.out.println(str1);
		System.out.println(str2);
		
		char[] arr1 = {'a', 'b', 'c' ,'d'};
		System.out.println(new String(arr1));
		System.out.println(String.valueOf(arr1));
		
		//숫자를 문자열로 변환
		String str3 = 1234+"";
		String str4 = String.valueOf(1234);
		
		
	}

}
