package com.bit;

interface Inter{
	void func();
}
 
abstract class Lec05{
	void func02() {
		System.out.println("추상 클래스의 기능");
	}
	public abstract void func();
}

class Lec55{
	public void func() {
		System.out.println("본 기능");
	}
}
class Outter05{
	static void func01() {
		// 익명클래스에서 객체 생성을 한번하고 안함		
		Lec55 obj = new Lec55() {
				
			@Override
			public void func() {
				// TODO Auto-generated method stub
				System.out.println("익명 클래스 만들기");
			}
		};
		obj.func();
//		obj.func02();
		
	}
}




//(new () {
//	void func() {
//		System.out.println("익명 클래스 만들기");
//	}
//}).func();


public class Ex05 {
	public static void main(String[] args) {
		Outter05.func01();
	}
}
