package com.bit;
class MyErrorException extends Exception{
	public MyErrorException() {
		super("내가 정한 메시지");
//		super("id or password 가 없서요");
	}
}
public class Ex14 {
	//main 에서 try~catch문이 돌고 있음
	//main에서 erro뜨면 catch로 빠져서 실행 종료
	public static void main(String[] args) {
		
		try {
			func(4, 4);	
		} catch (MyErrorException e) {
			// TODO: handle exception
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
//			System.out.println("던진 에러 받아서 처리");
		}
	}
	public static void func(int a, int b) 
			throws MyErrorException{
			if(a/b==1) {
				MyErrorException err = new MyErrorException();
				throw err;	
			}
			int su =a/b;
	}
}
