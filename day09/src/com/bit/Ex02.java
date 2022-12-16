package com.bit;
/*
 * ===상속===
 *  - 부모의 기능을 가져와서 사용한다.
 *  - 다중 상속을 지원하지 않는다 = 1개의 상속만 가능
 *  - 최상위 객체는 Object
 *  - java의 모든 class는 Object객체를 상속받고 있음 
 *  - 코드 재사용
 */

class Lec03{
	void func003() {
		System.out.println("Lec03의 func01()");
	}
}
class Lec02 extends Lec03{ //부모 클래스(super class)
	int su1=1111;
	void func01() {
		System.out.println("Lec02의 func01()");
//		this.func02();  부모는 자식의 메소드를 사용할 수 없다.
		
	}
}

public class Ex02 extends Lec02{ //Lec02의 자식 클래스 (sub class)

	public void func02() {
		System.out.println("Ex02의 func02()");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02 ex02 = new Ex02();
		System.out.println(ex02.su1);
		ex02.func01();
		ex02.func003();
	}

}
