package com.bit;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] target = {1,3,5,7,9};
		int[] result = new int[5];
		//깊은복사
//		System.arraycopy(target, 0, result, 0, 5);
		System.arraycopy(target, 1, result, 2, 3);
		target[1] = 2;
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
