package com.bit;

/*
 * final 문법
 */
public class Ex08 {
	public static void func() {
		System.out.println("func start");
		
		try {
			int a =4;
			int b = 0;
			int c = a/b;
			System.out.println(c);
			return;
		} finally {
			// TODO: handle finally clause
			//반드시 실행해야 함
			//Exception이 발생하던 안하던 무조건 실행됨
			
			//try ~ finally = catch가 필요없을 경우 사용된다.
			//try부분에서 return을 수행해도 반드시 실행됨
			System.out.println("func end");
		}
		
		
	}
	
	public static void main(String[] args) {
		func();	
		}
}
