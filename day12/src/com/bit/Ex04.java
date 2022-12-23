package com.bit;
/*
 * 예외처리!
 * 
 */
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		for (int i = 0; i < 4; i++) {
			try {
				System.out.println(arr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("배열 크기 초과 했습니다.");
			}
			
		}
	}

}
