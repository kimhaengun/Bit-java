package com.bit;

public class Ex07 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		func();
	}
	
	public static void func() {
		Thread th = Thread.currentThread(); //Thread.currentThread() = 최근에 실행한 스레드
		System.out.println(th.getName());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		func();
		Ex07 me = new Ex07();
		Thread th = new Thread(me);
		th.start();
	}

}
