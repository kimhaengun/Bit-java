package com.bit2;

class Ex10{
	public static int su1 =1111;
	static int su2 = 2222;
	private static int su3 = 3333;

	private Ex10(){
	}
	Ex10(int a){}
	public Ex10(int a, int b){}

	public static void fun01(){
		System.out.println("f1");
	}
	
	public void fun02(){
		System.out.println("f2");
	}
	
	private static void fun03(){
		System.out.println("f3");
	}

}