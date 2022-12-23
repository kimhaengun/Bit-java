package com.bit;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/*
 * map
 */
public class Ex01 {
	public static void main(String[] args) {
		//map - key : value 쌍으로 존재
		//map의 결과를 보기 위해서는 key값을 주면됨
		//key는 어떤 타입으로든 작성 가능하다.
		//value값의 중복이 가능하다.
		//key값의 중복은 허용X
		//key값이 중복이 될 경우 맨마지막 결과값으로 덮어씌워진다.
		//key가 없는 값을 출력시 결과는 null
		// key : value
		//1. Map 생성
		//2. Map 값 추가
		//3. Map 수정 (key값 같게해서 덮어씌기)
		//4. Map 삭제 = null로 만들어버리기
		//5. 반복가능 Iterator
		
		//array 는 인덱스에 따라 값을 불러오지만 Map은 index에 해당되는 구분을 key로 사용하여 값들을 분류
		// key는 Tree / value는 List로 구성되어 있음
		
		Map map = new TreeMap();
//		map.put("key1", "val1");
//		map.put(1234, "val2");
//		map.put('a', "val3");
//		map.put(true, "val4");
//		map.put(null, "val5");
		
		map.put("key2", 1234);
		map.put("key3", 'a');
		map.put("key4", true);
		map.put("key5", null);
		
		System.out.println("size :"+map.size());
		
//		Collection list =  map.values();
//		Iterator ite = list.iterator();
//		while(ite.hasNext()){
//			System.out.println(ite.next());
//		}
		
//		Set entrys = map.entrySet(); //entry는 key와 value를 묶은 한 쌍(entry객체로 만듬)
//		Iterator ite = entrys.iterator();
//		while(ite.hasNext()) {
//			Entry entry = (Entry) ite.next();
//			System.out.println(entry.getKey()+" : "+entry.getValue());
//			
//		}
		
		//key가 set이라는 개념과 비슷하여 실행한 예제 ex) key는 중복 불가
		Set keys = map.keySet();
		Iterator ite = keys.iterator();
		while(ite.hasNext()) {
			Object key = ite.next();
			System.out.print(key);
			System.out.print(" : ");
			System.out.println(map.get(key));
		}
		
		
//		System.out.println(map.get(1234)); 
//		System.out.println(map.get(true)); 
//		System.out.println(map.get('a'));
//		
//		System.out.println(map.get("key3")); 
//		System.out.println(map.get("key4")); 
//		System.out.println(map.get("key5")); 
//		System.out.println(map.get("key6"));
		
	}
}
