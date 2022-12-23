package com.bit;

//구현이 없는 클래스(추상 클래스) - abstract
//추상메서드를 0개 이상 갖는 클래스 = 추상메서드가 없을 수도 있다.!!
// 객체 생성 x = new 못함
// 추상클래스는 상속을 강제화 한다.
abstract class Lec06{
	int su1 = 1111;
	public Lec06(int su) {
		this.su1 = su;
	}
	//추상 메서드의 접근제한은 default 이상으로 생성 (private 사용 X)
	public abstract void func01(); //추상메서드
	public void func02() {
		
	}
}

//추상 클래스 사용 방법 --> 상속하기
//이때 상속을 해서 사용하게 되면 추상 클래스의 메서드를 오버라이딩해서 사용해야한다.

public class Ex06 extends Lec06{
	public Ex06() {
		super(111);
	}
	
	//부모 메서드 오버라이딩
	@Override
	public void func01() {
		// TODO Auto-generated method stub
		System.out.println("부모 메서드를 오버라이드...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lec06 lec06 = new Lec06();
//		Ex06 ex06 = new Ex06();
		//첫번쨰 방법
//		ex06.func01();
		//두번째 방법
//		Lec06 lec06 = new Ex06();
//		lec06.func01();
	}

}
