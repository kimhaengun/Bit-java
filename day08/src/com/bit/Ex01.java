package com.bit;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String msg1 = "문자열";
		String msg2 = "문자";
		String msg3 = "열";
		String msg4 = msg2+msg3;
		String msg5 = "문자"+"열";
//		System.out.println(msg1==msg2+msg3);
//		System.out.println(msg1==msg4);
//		System.out.println(msg1==msg5);
		
		String str = new String();
//		System.out.println(str);
		
		char[] arr = {'a', 'b', 'c', 'd'};
		String str2 = new String(arr, 0, 4);
		String str3 = new String("문자열");
//		System.out.println(str2);
		
		//String Method
		//1. 문자열 합치지(더하기)
		String msg6 = msg2.concat(msg3);
		System.out.println(msg6);
		System.out.println(msg1==msg5);
		System.out.println(msg1==msg6);
	}

}
