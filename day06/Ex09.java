package com.bit;

// 접근 제한자 (class, 생성자, 전역변수, 메서드)
// public - 어디서든지 허용
// default - 동일 패키지에서만 접근을 허용
// private - 외부에서 접근 불가능
// 
// class 기준 
// public 
// default
///////////
// 생성자 - public, default, private
// 전역변수, 메서드 - public, default

// *class가 private로 설정되었을 경우*
/*
private static Ex09 me = new Ex09();

public static Ex09 newInstance(){
	return me;
}
*/ 


class Ex09{
	public static void main(String[] args){
		//System.out.println(com.bit2.Ex10.su1);
		//System.out.println(com.bit2.Ex10.su2);
		//System.out.println(com.bit2.Ex10.su3);
		//com.bit2.Ex10.fun01();
		com.bit2.Ex10 ex10;
		ex10 = com.bit2.Ex10(1,2);
			
	}
}