package com.bit;

class Lec05 extends Thread{
	int su1,su2;
	static int sum;
	static Object key = new Object();
	
	public Lec05(int su1, int su2) {
		this.su1 = su1;
		this.su2 = su2;
		
	}
	
	public synchronized static void hap(int a) {
		//성능 이슈있음 synchronized
		
		int tot = sum+a;
		sum = tot;
		
		
	}
	
	public void hap(int su1, int su2) {
		//성능 이슈있음 synchronized
		for (int i = su1; i <= su2; i++) {
			synchronized(this) { //this = key, 여러 스레드가 여기 접근시 스레드는 동일한 하나의 키를 가지고 있어야함
				int tot = sum+i;
				sum = tot;				
			}
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		hap(su1,su2);
//		for (int i = su1; i <= su2; i++) {
//			hap(i);
//		}
		System.out.println("합계="+sum);
	}
}
public class Ex05 {
	public static void main(String[] args) {
		Lec05 lec1 = new Lec05(1, 5000);
		Lec05 lec2 = new Lec05(5001, 10000);
		Thread th1 = new Thread(lec1);
		Thread th2 = new Thread(lec1);
		
		th1.start();
		th2.start();
	}
}
