package com.bit;

class Lec04{
	int su1 =1111;
	public void func01() {
		System.out.println("root 기능");
	}
}

class Lec44 extends Lec04{
	
}

class Lec55 extends Lec04{
	
}

public class Ex04 extends Lec04{

	// 상속받은 클래스의 메소드 명과 내 클래스의 메소드 명이 같을 경우 자신의 메소드가 실행된다.
	//  = 메서드 오버라이드     --> 메서드를 재정의 해버림
	//					       접근 제한자는 같거나 보다 열리는 방향으로만 허용
	// * 메서드만 해당 *
	@Override
	public void func01() {
		System.out.println("Ec04-func01()");
	}
	public String toString() {
		return "나야나";
	}
	public boolean equlas(Object obj) {
		return 0==this.su-((Ex04)obj).su;
	}
	int su;
	public Ex04(int su) {
		this.su=su;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04 ex04 = new Ex04(1);
		Ex04 ex040 = new Ex04(2);
//		ex04.func01();
//		System.out.println(ex04.su1);
//		System.out.println(ex04);
	}

}
