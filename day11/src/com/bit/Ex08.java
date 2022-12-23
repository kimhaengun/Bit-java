package com.bit;

public class Ex08 {
	
	public static void func(Object su) {
		
	}
	
//	public static void func(double su) {
//		
//	}
	
	
	
	public static void main(String[] args) {
		// 래퍼 클래스
		// Boxing  --> byte, long을 Byte, Long Object로 변환 
		//UnBoxing --> Byte, long을 byte, long 기본 자료형으로 변환
		// ex) 오브젝트는 연산이 불가능하다.
		//     ex) Long a + Long b를 연산한다고 코드를 작성할 경우 프로그램이 알아서 long 기본자료형으로 UnBoxing 시켜줌
		
		func(123); //오토 캐스팅 --> int형이 double로 형 변환됨.
		func(new Integer(123)); // = func(123);
		
		int su1 = 1111;
		Integer su2 = new Integer(2222);
		System.out.println(su1+su2);
		
		Integer su3 = 3333;
		Integer su4 = new Integer("3333"); //string 매개변수는 숫자로만 구성되어 있어야한다 ex)44a4 불가
		System.out.println(su3 == su4); // 값은 같지만 객체(Integer은 객체) 래퍼런스가 다르기 떄문에 false
		System.out.println(su3.intValue() == su4.intValue());  //값 비교
		System.out.println(su3.equals(su4)); //값 비교
		System.out.println(Integer.SIZE); //32
		System.out.println(Integer.BYTES); //4
		System.out.println(Integer.MAX_VALUE); //2147~
		System.out.println(Integer.MIN_VALUE); //-2147~
		System.out.println(Integer.parseInt("1234")+5115);
		
		int su = 3;
		System.out.println(Integer.reverse(su));
		
		System.out.println("===============2, 8, 16 진수==============");
		//return 값  = 문자열
		int su5 = 8;
		System.out.println(Integer.toBinaryString(su5)); //2진수
		System.out.println(Integer.toOctalString(su5)); //8진수
		System.out.println(Integer.toHexString(su5)); //16진수

		System.out.println("=============================");
		byte su11 = 1;
		Byte su10 = new Byte(su11); //Byte su10 = new Byte(1); --> 불가능 byte 값으로 매개변수에 넣어야함
		
		
		System.out.println(Integer.compare(su2, su3));//2222>3333 //같으면 0, 작으면 -1, 크면 +1
		//non-static
		System.out.println(su2.compareTo(su3));//2222>3333 //같으면 0, 작으면 -1, 크면 +1
	
	}
}
