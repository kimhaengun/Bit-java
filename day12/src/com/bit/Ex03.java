package com.bit;

public class Ex03 {
	public static void main(String[] args) {
		int[] lotto = new int[45];
		//45개 넣기
		for (int i = 0; i < lotto.length; i++) {
			lotto[i]=i+1;
		}
		// 섞기
		for (int i = 0; i < 10000; i++) {
			int su1 = (int)(Math.random()*45);
			int su2 = (int)(Math.random()*45);
			int temp =lotto[su1];
			lotto[su1] = lotto[su2];
			lotto[su2] = temp;
		}
		for (int i = 0; i < 6; i++) {
			System.out.println(lotto[i]);
		}
		
	}
}
