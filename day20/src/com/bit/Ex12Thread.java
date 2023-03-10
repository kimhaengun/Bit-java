package com.bit;

public class Ex12Thread {

	public static void main(String[] args) {
		//set Priority 1~10
		//default = 5
		//max 10
		//min 1
		//상대적 빈도수
		Thread mainT = Thread.currentThread();
		System.out.println("main thread"+mainT);
		//Thread가 할 일
		Runnable thr = new Runnable() {
			public void run() {
				Thread thr = Thread.currentThread();
				int su = thr.getPriority(); //스레드 우선 순위
				System.out.println(thr.getName()+"Thread start"+su);
				try {
					
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("new thread end"+su);
			}
		};
		
		Thread thr1 = new Thread(thr);
		Thread thr2 = new Thread(thr);
		thr1.setPriority(Thread.MAX_PRIORITY);
		thr2.setPriority(Thread.MIN_PRIORITY);
		thr1.start();
		thr2.start();
	}
}
