package com.bit;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 *  LinkedList vs ArrayList
 *  데이터를 넣는 시간은 비슷비슷하지만
 *  데이터를 넣고 가져오는 과정에서는 ArrayList가 훨씬 빠름 (데이터를 넣고 가져오는 과정의 gap 차이가 없다고 보면됨)
 */
public class Ex04 {
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
//		Arr2 arr = new Arr();
//		ArrayList arr = new ArrayList();
		LinkedList arr = new LinkedList();
		for (int i = 0; i < 100000; i++) {
			arr.add(i);	
		}
		

//		arr.add(2222);
//		arr.add(3333);
//		arr.add(4444);
//		
		for (int i = 0; i < arr.size(); i++) {
			Object obj = arr.get(i);
		}
		long after = System.currentTimeMillis();
		System.out.println(after-before);		
		
	}
}
