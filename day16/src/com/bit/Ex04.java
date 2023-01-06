package com.bit;

public class Ex04 {

	public static void main(String[] args) {
		// 1. 스레드 객체 생성
		// 2. 익명 함수 Runnable
		// 3. 스레드 객체 매개변수에 Runnable
		
		;
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Thread th = Thread.currentThread();
				String name = th.getName();
				System.out.println(name);
			}
		});
		
		th.start();
	}
}
