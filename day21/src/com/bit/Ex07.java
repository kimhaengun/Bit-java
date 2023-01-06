package com.bit;

class Lec07 extends Thread{
	boolean boo = true;
	boolean boo2 = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(boo) {
			if(boo2) {
				System.out.println("working ...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}else {
				//boo2가 false일 떄 다른 스레드한테 작업을 양보함
				//그러다 3초 뒤 boo2가 true로 바뀌면서 Runnable 상태로 갈 수 있음
				yield();
			}
		}
	}
}
public class Ex07 {

	public static void main(String[] args) {
		Lec07 lec = new Lec07();
		lec.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lec.boo2 = false;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lec.boo2=true;
	}
}
