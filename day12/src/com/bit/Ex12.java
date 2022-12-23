package com.bit;
/*
 * 
 */
public class Ex12 {
	public static void main(String[] args) {
		int[] arr1 = {-2,-1,0,1,2};
		
			for (int i = 0; i < 6; i++) {
				try {
//				try {
					System.out.println(3/arr1[i]);	
//				} catch (ArithmeticException e) {
//					// TODO: handle exception
//					
//				}
					
			}	
		 catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		//Error --> ex) 메모리가 곧 초과되니 어떠한 조치를 취할 준비를 하라고 알려줘야하는데 Throws를 걸어버리면 이 경고를 무시하기 때문에 쓰면 안됨.
			
		
	}
}
}