package com.bit;
class Ex01{
	public static void main(String[] args){
		System.out.println("=== 1. 다음을 출력하시오. ===");
	//          *
	//          **
	//          ***
	//          ****
		for(int i=1; i<5; i++){
			for(int j = 1; j<=i  ; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}

		System.out.println("=== 2. 다음을 출력하시오. ===");
	//          1
	//          12
	//          123
	//          1234
		for(int i=1; i<5; i++){
			for(int j = 1; j<=i  ; j++){
				System.out.print(j);
			}
			System.out.print("\n");
		}		

		System.out.println("=== 3. 다음을 출력하시오. ===");
	//          1
	//          23
	//          456
	//          78910
		
		int num = 1;
		for(int i  =1 ; i< 5; i++){
			for(int j = 1;  j<=i ; j++){
				System.out.print(num);
				num++;
			}
			System.out.print("\n");	
		}		
		System.out.println("\n=== 4. 다음을 출력하시오. ===");
	//          ****
	//          ***
	//          **	
	//          *

		for(int i =1; i< 5; i++){
			for(int j = 5; j>i; j--){
				System.out.print("*");
			}
			System.out.print("\n");
		}

		System.out.println("=== 5. 다음을 출력하시오. ===");
	//             *
	//            **
	//           ***	
	//          ****

		for(int i =1; i< 5; i++){
			for(int j = 4; j>i; j--){
				System.out.print(" ");
			}
			for(int j1 = 1; i>=j1; j1++){
				System.out.print("*");
			}
			System.out.print("\n");

		}
	
	}
}