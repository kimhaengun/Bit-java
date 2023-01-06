package com.bit;

public class Ex01 {
	public static void func() {
		System.out.println(Thread.currentThread().getName());
	}
	public static void func2() {
		System.out.println(Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		System.out.println(Thread.currentThread());
		func();
		func2();
		System.out.println("main end");
	}

}
