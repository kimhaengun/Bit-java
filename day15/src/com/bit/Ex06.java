package com.bit;
/*
 * 익명 클래스
 * 익명 클래스는 인스턴스를 할 수 없기 때문에 인터페이스를 상속받아서 구현
 */
interface Inter20{
	void func();	
}

public class Ex06 {
	static Inter20 obj = new Inter20() {
		public void func() {
			System.out.println("기능 구현");
		}
		//인터페이스에 메소드 정의하지 않은 메소드는 사용할 수 없다.
//		public void func01() {
//			System.out.println("야양야야야양야야야");
//		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스 명이 없기 때문에 부모 타입으로 명세
		Ex06.obj.func();
//		Ex06.obj.func01();
	}

}
