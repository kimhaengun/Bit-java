package com.bit;

public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr1 = new String[4];

		Ex09[] arr2 = new Ex09[3];
		arr2[0]=new Ex09();
		int[][] arr3; 
		arr3 = new int[3][];
		arr3[0] = new int[] {1,2,3};
		arr3[1] = new int[] {4,5};
		arr3[2] = new int[] {6};
		
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
					System.out.print(arr3[i][j]);
			}
			System.out.println();
		}
		
	}

}
