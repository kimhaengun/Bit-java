package com.bit;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 문자들의 집합
		System.out.println("흐에!");
		
		//객체 있음
		String str1 = "문좌욜";
		System.out.println(str1);
		
		//객체 없음
		String str = null;
		System.out.println(str);
		
		//객체 있음 , 문자가 없음
		String str2 = "문좌욜";
		String str3 = new String();
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		
		Scanner sc = new Scanner(System.in);
		String str4 = sc.nextLine();
		System.out.println(str4.equals(str2));
		
	}
}

