package com.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex03 {
	public static void main(String[] args) {
		
		//제네릭은 참조변수 타입만 가능하다.. = intx, IntegerO
		// wrapper 클래스를 사용
		//장점 잘못된 데이터 타입을 넣는 것을 방지 / 값가져올 시 캐스팅이 필요없음
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1111);
		arr.add(2222);
		arr.add(3333);
		arr.add(4444);
		
		for (int i = 0; i < arr.size(); i++) {
			int obj = arr.get(i);
			System.out.println(obj);
		}
		
//		Map<String, String> map = new HashMap<String, String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
	}
}
