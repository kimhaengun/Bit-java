package com.bit;

/*
 *  yield --> Running 상태일 때 yield를 걸게 되면 Runnable 상태로 변환됨
 *            이때 Runnable 상태 이기 떄문에 다시 Running 상태가 될 수 있음
 *            
 */
class Lec04 extends Thread{
	boolean boo;
	public Lec04(boolean boo) {
		this.boo = boo;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(boo)yield();
			System.out.println(getName()+" working ..."+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class Ex04 {

	public static void main(String[] args) {
		Lec04 ex1 = new Lec04(false);
		Lec04 ex2 = new Lec04(true);
		ex1.start();
		ex2.start();
		for (int i = 0; i < 10; i++) {
			ex1.yield();
		}
	}
}
