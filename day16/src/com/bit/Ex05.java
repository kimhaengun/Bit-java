package com.bit;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th = new Thread() {
			public void run() {
				Thread th = Thread.currentThread();
				String name = th.getName();
				System.out.println(name);
			}
		};
		
		th.start();
	}

}
