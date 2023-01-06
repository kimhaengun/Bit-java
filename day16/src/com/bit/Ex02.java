package com.bit;

public class Ex02 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println("새로운 스레드로 "+name+" 작업 시킵니다.");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" start");
		Ex02 thr = new Ex02();
		
		thr.start(); //run()을 알아서 불러줌  / 지금의 스레드가 아닌 새로운 스레드 실행됨.
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" 일 중");
		}
		System.out.println(Thread.currentThread().getName()+" end");
		
	}

	
}
