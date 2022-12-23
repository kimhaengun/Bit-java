package com.bit;

/*
 * 		System.out.println()을 요청하면 자바는 콘솔을 찍어달라는 요청을  OS에 하게 되고 OS가 응답을 줄때까지 자바는 기다리기 떄문에 시스템 성능에 영향을 주게 된다.
 */

public class Ex06 {
	public static void main(String[] args) {
		System.out.println("시작");
		int su1 = 4;
		int[] arr= {-2,-1,0,1,2};
		for (int i = 0; i < arr.length; i++) {
		try {
		
				System.out.println(su1/arr[i]);
			}catch (ArithmeticException e) {
				System.out.println(e.toString());
				System.out.println(e.getMessage());
				System.out.println(e.getClass());
				//sysout 대처용 
				e.printStackTrace(); //error stack에 보관했다가 자바 실행 중 한가할? 때 에러 출력
			}
		}
		System.out.println("종료");
	}
}
