package com.bit;

public class Ex08 extends Thread{
	public Ex08() {
		super(" poThreadwer");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread th = Thread.currentThread();
//		th.setName("스으레으드으");
		System.out.println(this.getName());
		System.out.println(th.getName());
		System.out.println(th==this);
		System.out.println(this.getId());
		System.out.println(th.getId());
		
	}
	public static void main(String[] args) {
		Ex08 me = new Ex08();
		me.start();
	}
}
