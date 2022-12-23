package com.bit;

import java.util.ArrayList;

public class Ex05 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		System.out.println(list.add(1));
		list.add(1111);
		list.add(2222);
		list.add(3333);
		
		ArrayList list2 = new ArrayList();
		list2.add(2222);
		list2.add(3333);
		list2.add(4444);

//		list2.addAll(0,list);
//		list2.clear();
		
//		list2.remove("item1");		
		//remove 우선순위는 index ex)arrayList 값에  1이 있을때 remove(1)을 하면 인덱스[1]의 값이 지워진다.
//		list2.remove(1);
		
//		list2.removeAll(list);
		
		//set으로 값을 변환하면 Object[]을 하나 만들서 받아야함
		list2.set(1, 5555);
		Object[] arr3 = list2.toArray();
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(arr3[i]);
		}
		
		//arrayList에 해당 값이 있는지 확인
//		System.out.println(list2.contains(3333));
		
		
	}
}
