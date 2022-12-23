package com.bit; 


// 패키지안 모든 클래스 import = *
// import com.bit2.*;
// *을 걸어줘도 해당 클래스를 찾을 떄는 우선순위는 1.자신의 패키지 내 클래스 탐색 2.*이 붙은 패키지 명에서 해당 클래스 탐색
import com.bit2.*;
import static java.lang.Math.PI;

public class Ex02 {
	public static void main(String[] args) {
		//클래스명이 같을 경우 
		//동일 패키지라도 com.bit. --> 패키지 명을 따로 작성해줘야한다.
		com.bit.Ex01 ex01 = new com.bit.Ex01();
		Ex01 ex11 = new Ex01();
		
		System.out.println(ex11.su);
		System.out.println(PI);
		System.out.println(ex01);
	}

}
