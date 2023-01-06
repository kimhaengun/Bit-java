package com.bit;


import java.util.*;


public class Ex07 {
	
	public static Box<? super Integer> func(int su){
		//super 자신타입 포함 부모타입 사용 가능 ex) super Integer --> Integer, Number 사용 가능
		//extends 부모타입 기준 자식타입 꺼 사용 가능 ex) extends Number --> Double, Integer 사용가능
		
		if(su>0) {
			return new Box<Number>();
		}else {
			return new Box<Integer>();
		}
	}
	
	
	public static void main(String[] args) {
		//차이점?? 대입 연산자는 늦게 일어남 
		Box<String> box = new Box<String>();
		Box<String> box1 = new Box(); //객체 생성 당시 제네릭 없음, 값 넣을 시 String만 가능
//		box1.setSu("1234");
		
		Box box2 = new Box<String>();
		box1.setSu("1234");
		Object obj = box2.getSu();
		System.out.println(obj);
		
		Box<String> box3 = new Box<>();
		Box<?> box4 = new Box<String>();
		((Box<String>)box4).setSu("");
	}
}
