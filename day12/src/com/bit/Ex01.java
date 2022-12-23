package com.bit;

import java.util.Arrays;
import java.util.Collections;

public class Ex01 {
	public static void main(String[] args) {
		// 1~45 6개
		System.out.println("로또번호생성기(ver 0.1.0)");
//		0<=ran<1
// 		0*10<=ran<1*10   // 0~9.9999
//      0.*10+1 <= ran < 1*10+1  // 1~10
//      0.*45+1 <= ran < 1*45+1 // 1~45
		int su =45;
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
//			if(i==1) {
//				lotto[0]==lotto[1]
//			}else if(i==2) {
//				lotto[0]==lotto[2],
//				lotto[1]==lotto[2]
//			}
			lotto[i]=(int)(Math.random()*su)+1;
			for (int j = 0; j < i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
				
			}
		}

		for (int i = 0; i < lotto.length-1; i++) {
			for (int j = i+1; j < lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int temp = lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		for (int i = 0; i < lotto.length; i++) {
		System.out.print(lotto[i]+" ");
		}		
		//short
		//오름차순
//		Arrays.sort(lotto);
//		for (int i = 0; i < lotto.length; i++) {
//			System.out.print(lotto[i]+" ");
//		}
//		
//		//내림차순
		//배열 Integer로  해야함
//		Arrays.sort(lotto, Collections.reverseOrder());
		
	}
}
