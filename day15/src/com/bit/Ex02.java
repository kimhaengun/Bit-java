package com.bit;

import com.bit.Outter02.Inner02;
// 상속이 나오기 전 내부 클래스를 사용하였지만 현재 사용x
// 보기 불편함 = 가독성이 안좋음
// 객체 지향이 나온 후 사용안함
// 주로 사용될 때 = 외국 or 안드로이드 -->
// 사용성이 떨어짐 --> 재사용성 x

class Outter02{
	static int su1 = 1111;
	int su2 =2222;
	
	static class Inner02{
		static int su3 = 3333;
		int su4 = 4444;
		
		Inner02(){
			
		}
		static void func03() {
//			System.out.println(su1);
//			func01();
//			Outter02 outt = new Outter02();
//			System.out.println(outt.su2);
//			outt.func02();
		}
		void func04(){
//			System.out.println(su1);
//			func01();
//			Outter02 outt = new Outter02();
//			System.out.println(outt.su2);
//			outt.func02();
		}
	}
	
	Outter02() {
		// TODO Auto-generated constructor stub
	}
	static void func01() {
//		Inner02 inn1 = new Inner02();
//		System.out.println(Inner02.su3);
//		Inner02.func03();
//		System.out.println(inn1.su4);
//		inn1.func04();
	}
	void func02() {
//		Inner02 inn1 = new Inner02();
//		System.out.println(Inner02.su3);
//		Inner02.func03();
//		System.out.println(inn1.su4);
//		inn1.func04();
		
	}
}
public class Ex02 {
	public static void main(String[] args) {
		System.out.println(Outter02.su1);
		Outter02.func01();
		Outter02 outt = new Outter02();
		System.out.println(outt.su2);
		outt.func02();
		/////////////////////////////////////
		// inner class
		System.out.println(Outter02.Inner02.su3);
//		Inner02 inn = new Inner02();
		Outter02.Inner02.func03();
		Outter02.Inner02 inn = new Outter02.Inner02();
		System.out.println(inn.su4);
		inn.func04();
		
	}
}
