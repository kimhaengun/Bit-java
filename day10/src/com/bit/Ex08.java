package com.bit;

// interface
// 상속 개념이 아님
// 필드, 생성자 존재 x
// 자바는 다중 상속이 안되기 떄문에 대안책? 정도로만 나온 친구

interface Lec08{
	public final static int su1 = 1111;
	//public 키워드 생략 가능
	final static int su2 = 2222;
	//final 키워드 생략 가능
	static int su3 = 3333;
	//static 키워드 생략 가능
	int su4 = 4444;
	
	
	public abstract void func01();
	//abstract 키워드 생략 가능
	public void func03();
	//public 키워드 생략 가능
	void func04();
	// 구현된 메서드를 가질 수 없음.
//	public void func03() {
//		
//	}
	
}

//인터페이스간 상속 = extends

interface Lec09 extends Lec08{
	public abstract void func02();
	
}

// 상속 = extend 1개
// 인터페이스 = implements 여러개 가능.(다중 상속 가능)

public class Ex08 extends Object implements Lec08, Lec09{
	public void func01() {
		
	}
	public void func02() {
		
	}
	@Override
	public void func03() {
		// TODO Auto-generated method stub
		
	}
	public void func04() {
		
	}
	
	public static void main(String[] args) {
		Lec08 me = new Ex08();
		me.func01();
		System.out.println(Lec08.su3);
	}

}
