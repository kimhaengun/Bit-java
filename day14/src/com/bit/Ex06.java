package com.bit;

class Lec06{
	
	private Lec06() { //클래스 내에서 객체 생성가능 - private
		
	}
	
	public static <T>T newInstance(T t) { //static에 띄워서 사용하기 때문에 Lec06() 사용가능
		T me = t;
		return me;
	}
}

class Lec66{
	public static <T> Box<T> newInstance(T t) {
		Box<T> box = new Box<T>();
		box.setSu(t);
		return box;
	}
}


public class Ex06 {
	public static void main(String[] args) {
		Box<String> box = Lec66.<String>newInstance("아아아아아");
		String msg = box.getSu();
		System.out.println(msg);
		byte a = 12;
//		int[] b;
//		b = {2,3,4,}; // b는 int[]이라는 것을 알지만 b에 값을 대입할때 int형이 온다라는 보장이 없기 때문에 , new int[] / int배열이라고 선언해줘야함
		int[] b;
		b = new int[]{1,2,3,};
	}
}
