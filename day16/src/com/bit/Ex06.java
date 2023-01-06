package com.bit;

public class Ex06 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread th = this;
		System.out.println(th.getName());
		System.out.println(this.getName());
		System.out.println(getName());
		Thread th2 = Thread.currentThread();
		System.out.println(th2 == this);
	}
	public static void main(String[] args) {
		Ex06 ex06 = new Ex06();
		ex06.start();
	}
}
