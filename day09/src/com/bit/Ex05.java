package com.bit;


class Lec05{
	void func01() {
		System.out.println("Lec04-func01()");
	}
}
public class Ex05 extends Lec05{
	int su1 =2222;
	void func01() {
		System.out.println("Ex05-func01()"+su1);
	}

	void func02() {
		System.out.println("Ex05-func02()"+su1);
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Lec05 lec05 = new Lec05();
		lec05.func01();
		Ex05 ex05 = new Ex05();
		ex05.func01();
		ex05.func02();
		
		Lec05 lec051 = new Lec05();
		lec051.func01();
//		lec05.func02();
	}

}
