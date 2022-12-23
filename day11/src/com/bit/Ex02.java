package com.bit;

class Lec02{
//  접근 제한자
//	public > protected >= default > private
	
	protected int su1;
	protected void func01() {
		
	}
}
public class Ex02 extends com.bit2.Lec22{
	
	
	public static void main(String[] args) {
		Lec02 me = new Lec02();
		System.out.println(me.su1);
		me.func01();
		
		com.bit2.Lec22 you;
//		System.out.println(you.su1);
//		you.func01();
		Ex02 me2 = new Ex02();
		System.out.println(me2.su1);
		me2.func02();
		//default 허용x
//		me.func03();
		
		
	}
}
