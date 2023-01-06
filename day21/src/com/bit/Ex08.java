package com.bit;

/*
 *  DaemonThread
 */
class Lec08 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("running ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Ex08 {

	public static void main(String[] args) {
		System.out.println("main start");
		Lec08 lec = new Lec08();
		lec.setDaemon(true); //start 전 선언
		lec.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
