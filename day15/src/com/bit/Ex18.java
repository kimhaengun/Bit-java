package com.bit;

import java.util.StringTokenizer;

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target = "java web DB Framework";
//		String[] arr1 = target.split(",");
//		for (int i = 0; i < arr1.length; i++) {
//			System.out.println(arr1[i]);
//		}
		StringTokenizer stk ;
		stk = new StringTokenizer(target); //(target, ",") split기능을 수행할 수 있지만 아무것도 안적으면 default값으로 " "스페이스바 기준으로 자름
		// "java           web DB" << 이런식으로 String이 구성 되어 있을 경우 스페이스바를 구분해서 모두 날리고 javawebDB값만 가져옴
		System.out.println(stk.countTokens()); //토큰의 lenght를 구해줌
		while(stk.hasMoreElements()) {
			System.out.println(stk.nextToken());
		}
	}

}
