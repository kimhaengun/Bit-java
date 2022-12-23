package com.bit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Lec12 implements Comparable{
	int val = 1;
	
	public Lec12(int su) {
		val = su;
	}
	
	@Override
	public int compareTo(Object o) { //비교했을때 같으면 0, 다르면 얼마나 다른지
		// TODO Auto-generated method stub
		return val-((Lec12)o).val; //0으로 return 하면 같다고 선언해버리기 떄문에 오류x //내림차순
//		return ((Lec12)o).val-val;// 오름차순
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+val;
	}
	
}
public class Ex12 {
	public static void main(String[] args) {
		Set set = new TreeSet();
//		Lec12 me = new Lec12();
//		너는 순서가 뭐고??
		set.add(new Lec12(1111));
		set.add(new Lec12(4444));
		set.add(new Lec12(2222));
		set.add(new Lec12(5555));
		set.add(new Lec12(3333));
		set.add(new Lec12(8888));
		
		

		
//		set.add(me);
//		set.add(new Lec12());
		
		//Iterator = 컬렉션을 반복하는 객체
		Iterator ite = set.iterator();
		while(ite.hasNext()) {
			Object obj = ite.next();
			System.out.println(obj.toString()+ " "); //중복이면 하나만, 다르면 전부다 띄움 // 해쉬 코드값으로 정렬
		}
	}
}
