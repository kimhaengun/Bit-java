package com.bit;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1 = "가";
		byte[] arr1 =msg1.getBytes();
		System.out.println(arr1.length);
		// 문자코드와 엔코딩에 대해 알아보기
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		byte[] arr2 = new byte[3];
		arr2[0] = -22;
		arr2[1] = -80;
		arr2[2] = -127;
		String msg2 = new String(arr2);
		System.out.println(msg2);
		
	}

}
