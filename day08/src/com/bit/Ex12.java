package com.bit;

public class Ex12 {
	public static void main(String[] args) {
		//다음 배열에 값을+2씩하고 출력하라
		//int[] su1={1,4,6,7,9};
		int[] su1 = {1,4,6,7,9};
		for (int i = 0; i < su1.length; i++) {
			su1[i]+=2;
			System.out.print(su1[i]+" ");
		}

		System.out.println();
		// 0~10중 홀수를 담는 배열을 생성하고 출력하시오.
		int[] arr = new int[5];
		int ind=0;
		for (int i = 0; i < 11; i++) {
			if(i%2==1) {
				// 1,3,5,7,9
				arr[ind]=i;
				ind++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		//알파벳 대문자를 담는 배열을 만들고 출력하시오. 26
		char[] arr3 = new char[26];
		int ind2=0;
		for (char i = 'A'; i <= 'Z'; i++) {
			arr3[ind2]=i;
			ind2++;
		}
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		
		System.out.println();
		//다음을 오름차순 정렬 출력하시오.
		//int[] su4={9,10,20,7,2,4,8,3};
		// 20 10 9 8 7 4 3 2
		int[] su4 = {9, 10, 20, 7, 2, 4, 8, 3};
		int result;

		for (int i = 1; i < su4.length; i++) {
			for (int j = 0; j < su4.length; j++) {
				if(su4[i]>su4[j]) {
//					System.out.println("시작?? "+i+": "+su4[i]+", "+j+": "+su4[j]);
					result = su4[j];
					su4[j] = su4[i];
					su4[i] = result;
//					System.out.println(" 끝?? "+i+": "+su4[i]+", "+j+": "+su4[j]);
//					System.out.println();
					
				}
			}
		}
		
		for (int i = 0; i < su4.length; i++) {
			System.out.println(su4[i]+ " ");
		}
	}
	
}
