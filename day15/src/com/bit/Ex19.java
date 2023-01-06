package com.bit;

import java.util.Arrays;
import java.util.List;

public class Ex19 {
	public static void main(String[] args) {
		String[] arr1 = {"java","DB","web","framework"};
		
		// arr1의 배열의 길이 만큼 arr2에 복사
		String[] arr2 = Arrays.copyOf(arr1, arr1.length-1);
		
		//arr1의 인덱스 1~length-1 만큼 복사 (일부만 복사)
		String[] arr3 = Arrays.copyOfRange(arr1, 1, arr1.length-1);
		arr1[1]="database";
		
		// arr2 값을 확인하기 위해 for문을 돌려야 하지만
		// Arrays.toString 쓰면 배열안의 값을 볼 수 있음.
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = new int[3];
		// 빈 배열에 값채워 넣기
		Arrays.fill(arr4, 1234);
		
		int[] arr5 = {1234,1234,1234};
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.equals(arr4, arr5)); //인자 비교하기 (배열 비교)
		
		
		int[] lotto= {45,3,26,7,25,31};
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		
		//binarySearch를 하기 전에 sort 필수!!!
		System.out.println(Arrays.binarySearch(lotto, 26)); //해당 숫자가 인덱스 몇번에 있는지
		
		
		List<Integer> list = Arrays.asList(45,3,26,7,25,31); // list를 배열로 만들어줌
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		func(1,2,3,4,5);
	}
	public static void func(int ...a) { // <...> 배열로 인식함 / 매개 변수 두개를 받을 경우 가변적이지 않는 값부터 받기 --> (String a, int ...a) = 순서 바뀌면 안됩니다~
		System.out.println(Arrays.toString(a));
		
	}
	
}
