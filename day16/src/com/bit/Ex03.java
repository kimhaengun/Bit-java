package com.bit;

import java.util.LinkedList;
import java.util.List;

public class Ex03 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread th = Thread.currentThread();
		String name = th.getName();
		System.out.println(name+ " Start ..." );
		System.out.println(name+ " End ..." );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Runnable 상속
		// 2. run() 오버라이드 받아서 구현
		// 3. Thread 생성 시 나 자신(Ex03)을 참조할 수 있도록 new Thread(new Ex03())
		
		Thread th2 = new Thread(new Ex03());
		th2.start();
		Thread th = Thread.currentThread();
		String name = th.getName();
		System.out.println(name+" Start ...");
		
		List list = new LinkedList();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}

		System.out.println(name+" End ...");
	}


}
