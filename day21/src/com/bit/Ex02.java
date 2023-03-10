package com.bit;

/*
 *  Thread Control
 *  start() --> Runable(시작 대기 상태) <--> Running
 *  여러 개의 Runable 중인 Thread를 랜덤으로 Thread를 Running 시키고 다시 Runable 
 *      --> Runable <-->Running 과정을 반복하면서 여러 스레드를 동작시킨다.
 *  sleep()를 사용하게 되면 해당 Thread는 TimedWaiting 상태로 대기했다가 sleep이 끝나면 Runnable 상태로 돌아감 = sleep 이 끝난다고 해서 바로 Running상태가 되는 것은 아님
 *  
 *  
 */

public class Ex02 extends Thread{

	@Override
	public void run() {
		System.out.println(getName()+"  start...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName()+"  end...");
	}
	
	public static void main(String[] args) {
		System.out.println("main start...");
		Ex02 me =new Ex02();
		me.start();
		try {
			//join을 걸게 되면 Thread sleep이 끝날 때 까지 대기하고 있음. = wating상태
			// But 특정 시간을 걸게 되면 Thread sleep을 기다리지 않음 = me.join(3000); 
			me.join(); 	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end...");
	}
}
