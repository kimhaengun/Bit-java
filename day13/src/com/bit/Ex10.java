package com.bit;

import java.util.Vector;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Vector vec;
		vec = new Vector();
		// List , jdk 1.2 등장 전
		vec.addElement(1111);
		vec.addElement(4444);
		vec.addElement(3333);
		vec.addElement(5555);
		vec.addElement(2222);
		
		//순서가 없을 경우 값 가져오기
		java.util.Enumeration enu;
		enu = vec.elements();
	
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());	
		}
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		
//		System.out.println("==============");
//		System.out.println(vec.elementAt(0));
//		System.out.println(vec.elementAt(1));
//		System.out.println(vec.elementAt(2));
//		System.out.println(vec.elementAt(3));
//		System.out.println(vec.elementAt(4));
		
		
	}

}
