package com.bit;
/*
 * HashSet
 */
public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//순서 없는 자료 구조 - 집합
		//1. 중복을 허용하지 않는다.
		//2. 순서O
		// --> 순서가 있기 떄문에 중복검사를 할 수 있다...
		// --> 선형이지만 중복이 없음
		java.util.Set set1;
		set1 = new java.util.TreeSet();
		
		set1.add("첫번째");
		set1.add("두번째");
		set1.add("세번째");
		set1.add("네번째");
		set1.add("다섯번째");
		
		System.out.println(set1.remove(new String("다섯번째"))); // 중복된것을 지움
		
		java.util.Iterator ite;
		ite = set1.iterator();
		
		while(ite.hasNext()) { //다음이 잇냐?
			System.out.println(ite.next());
		}
		
//		Object[] arr = set1.toArray();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}

}
