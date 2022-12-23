package com.bit;

public class Ex10 {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer(5); //무조건 객체 생성해야함
		StringBuffer sb2 = new StringBuffer("java");
		StringBuffer sb3 = new StringBuffer("Web");
		StringBuffer sb4 = new StringBuffer(128);
		
		//append() = 더하기
		sb2.append(sb3); //java+web
		StringBuffer sb5 = sb2.append("야야야야야야야야야야야양야");   //위에 코드 실행되면 값을 그래도 가지고와서 자기 자신이 변환됨 ex) sb2 = javaWeb

		//		System.out.println(sb2);
//		System.out.println(sb5);
		
		for (int i = 0; i < 6; i++) {
			//최대 Buffer 공간보다 많은 값을 넣으면 알아서 공간 크기가 늘어남
			//늘어나는 식... (생성자에서 늘어난 값+16)
			//5
			//(5+1)*2 = 12
			//(12+1)*2 = 26
			//(26+1)*2 = 54
			
			sb1.append('5');
			sb1.trimToSize();
		}
		//늘어나고 사용안하는 Buffer 공간을 날려버림
		
		//sb2 = "java" = (사이즈 = 4) , 4+16 =20
		System.out.println(":"+sb1.capacity());
	}
}
