package com.bit;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1 = "문자"+"열";
		String msg2 = "문자".concat("열");
		//래퍼런스 비교
		System.out.println(msg1==msg2); //fasle
		//value(값) 비교
		System.out.println(msg1.equals("문자열")); //true
		
		byte[] bArr1 = msg1.getBytes(); //문자 전체를 담기
		char[] cArr2 = msg1.toCharArray();
//		char[] cArr3 = new char[3]; 
//		//원하는 문자만 받을 수 있다.
//		msg1.getChars(0, 3, cArr3, 0); //source 시작, 끝 ,  ,인덱스시작

		char[] cArr3 = {'a','b','c','d'}; 
		//문자 치환 msg1 값--> cArr3에 넘겨주기
		msg1.getChars(0, 2, cArr3, 1); //source 시작, 끝 ,  ,인덱스시작
		
		System.out.println(new String(cArr3)); //a문자d
		System.out.println(msg1.length());
		System.out.println(msg1.toString());
	}

}
