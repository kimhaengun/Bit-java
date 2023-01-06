package com.bit;

public class Ex09 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("새로운 스으레으드으 start");
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("새로운 스으레으드으 end");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex09 me = new Ex09();
		me.run();
		System.out.println("main start");
		try {
			Thread.sleep(1000); // Exception 필수 항목
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main end");
	}
}
