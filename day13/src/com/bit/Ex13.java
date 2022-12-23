package com.bit;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


class Lec implements Comparable{ // TreeSet을 사용하면 비교해야하는 조건이 필요하기 때문에 Comparable 인터페이스를 가져온다.
	int val = 1;
	
	public Lec(int su) {
		val = su;
	}
	
	@Override
	public int compareTo(Object o) { //비교했을때 같으면 0, 다르면 얼마나 다른지
		// TODO Auto-generated method stub
		return val-((Lec)o).val; //0으로 return 하면 같다고 선언해버리기 떄문에 오류x //내림차순
//		return ((Lec12)o).val-val;// 오름차순
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val+" ";
	}
}
public class Ex13 {
	public static void main(String[] args) {
		Set set = new TreeSet();
		int[] lottoList = new int[7];
		
		for (int i = 0; i < lottoList.length; i++) {
			int lottoNum = (int)(Math.random()*45+1);
			lottoList[i] = lottoNum;
			System.out.println(lottoList[i]);
		}
		
		for (int i = 0; i < lottoList.length; i++) {
			System.out.println(i+"번쨰");
			set.add(new Lec(lottoList[i]));
		}
		
		//Iterator = 컬렉션을 반복하는 객체
		Iterator it = set.iterator();
		
		while(it.hasNext()) { //it 값이 null일때까지 반복
			Object obj = it.next(); //Object에  it안에 들어 있는 값 넣기
			System.out.print(obj.toString());
			
			
		}
		
		
	}
}
