package com.bit;

class Outter04{
	static int su1 = 1111;
	int su2 = 2222;
	
	static void func01() {
		class Loc01 {
//			//static 존재 x
//			static int su3= 3333 ;
			int su4 = 4444;
//			static void func01() {
//				
//			}
			void func02() {
				System.out.println(su1);
				func01();
				Outter04 outt = new Outter04();
				System.out.println(outt.su2);
				outt.func02();
			}
		}
		Loc01 loc = new Loc01();
		System.out.println(loc.su4);
		loc.func02();
	}

	void func02() {
		int su5 = 5555; //jdk1.8~ final 키워드 생략 가능 / 1.8이하 버전에서는 final을 안붙이면 func02()에서 su5를 호출하는 부분이 에러가 떨어짐
		class Loc02 {
			final static int su3= 3333 ;
			int su4 = 4444;
			
			void func02() {
				System.out.println(su5);
				func01();
				System.out.println(su2);
				func02();
		}
	}
		System.out.println(su5);
		System.out.println(Loc02.su3);
		Loc02 loc = new Loc02();
		System.out.println(loc.su4);
		loc.func02();
}
}
public class Ex04 {

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
