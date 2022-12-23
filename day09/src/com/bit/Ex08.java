package com.bit;


class Stu{
	
	int[] arr = new int[0];
	
	void add(int su) {
//		int[] arr2=new int[2];
		//복사
//		arr2[0]=arr[0];
//		arr2[1]=su;
//		
////		arr2 --> arr
//		arr=arr2;
		//계속 추가할때마다 사이즈를 늘려줘야함
		int[] arr2= new int [arr.length+1];
		arr2[arr2.length-1]=su;
		arr =arr2;
		
		//1.
//		int[] arr2 = new int[3];
//		arr2[0]=arr[0];
//		arr2[1]=arr[1];
//		arr2[arr2.length-1]=su;
//		arr=arr2;
	}
	
}
public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
