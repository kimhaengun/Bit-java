package com.bit;
class Ex02{
	public static void main(String[] args){
/*
		배열
		자료형[] 배열명 = new 자료형[배열길이];
		호출==>배열명[인덱스]
		인덱스 법칙
			1. 0부터 시작
			2. 연속적
			3. 마지막 번호 == 배열길이 -1;
			4. ArrayIndwxOutBoundException
*/
		int[] a = new int[5];
		 a[0] = 1;
		 a[1] = 2;
		 a[2] = 3;
		 a[3] = 4;

		for(int i = 0; i<4; i++){
			System.out.println(a[i]);
		}
	}
}