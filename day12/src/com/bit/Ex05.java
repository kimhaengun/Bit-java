package com.bit;

public class Ex05 {
	public static void main(String[] args) {
		System.out.println("시작");
		try {
			int su1 = 4;
			int su2 = 0;
			int su3 = su1/su2;	
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("종료");
		}
		
		
		
	}
}
