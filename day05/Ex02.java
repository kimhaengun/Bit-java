package com.my;
// 클래스의 이름은 첫글자 대문자 영문으로 시작
// 영문숫자 조합에 띄어쓰기 불가
class Ex02{
	//클래스의 구성 요소
	//	  1. 메서드 (public static void 메서드 명(){ 실행코드; })
            //               메서드명();  --> 메서드 호출로 사용이 가능하다.
            //               매개변수로 인자 전달 메서드명(매개변수);
	//                  --> 매개변수의 개수, 인자 타입은 일치해야 한다.!!
	//               메서드의 이름은 중복 불가능
	//               메서드 명은 같지만 매개변수 인자가 다를 경우 명이 같아도 된다.
	//                   --> 메서드 오버로드

 	public static void func01(){
		System.out.println("func01() 실행");
	}

	public static void func02(int a){
		System.out.println("func02() 실행 전달받은 값 : "+a);
	}

	public static void func03(int a, String str){
		System.out.println("func03() 실행 전달받은 값 : "+a+", "+str);
	}

	// 메서드 명은 같지만 인자가 다를 경우
	public static void func04(int a){
		System.out.println("func04() 실행 전달받은 값 : "+a);
		// 모든 메서드는 return을 가지고 있지만 생략 가능..
		// return
	}

	public static void func04(int a, String str){
		System.out.println("func04() 실행 전달받은 값 : "+a+", "+str);
	}

	public static void main(String[] args){
		System.out.println("한글 되나2");
		func01();
		func02(1234);
		func03(777, "집에 가자");
		func04(555);
		func04(555, "밥 먹자");
	}
}
