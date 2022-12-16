package com.bit;

public class Ex10 {
/*
 *  1. main에서 arr 생성하여 heap 영역에 arr가 띄워짐
 *  2. func(int[] arr)를 호출하면 매개변수 arr는 main이 생성한 arr를 가리키고
 *  3. func에서 arr 값을 변경하고 종료하면 main arr는 변경된 arr를 가르킴
 * 
 *	//얕은 복사 --> 배열 값이 바뀜
 *  //깊은 복사 --> 배열 값이 안바뀜
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] {1,3,5,7};
		//배열 복사 (얕은 복사)

		
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println(arr2[i]);
//		}
		
		//배열 복사 (깊은 복사)
		int[] arr3 = new int[4];
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("a1 : "+arr1[i]);
		}
		
		arr1[1] = 2;
		func1(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("a1 함수 : "+arr1[i]);
		}
	}
	
	public static void func1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[0]=0;
		}
	}

}
