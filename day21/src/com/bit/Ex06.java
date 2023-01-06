package com.bit;


class Lec06 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				//2.for문 1번은 수행
				System.out.println(i+1+"번 수행...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//3.wait 스레드 하나 깨움 / notifyAll = 잠들어 있는 스레드 모두 깨움
				if(i>1)notifyAll();
			}
		}
		
	}
}

public class Ex06 {
	public static void main(String[] args) {
		System.out.println("main start...");
		Lec06 lec = new Lec06();
		lec.start();
		synchronized (lec) {
			try {
				System.out.println("wait!!!");
				//1.lock걸림
				//wait 사용시 무조건 synchronized 안에 선언
				lec.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("main end...");
		
	}
}
