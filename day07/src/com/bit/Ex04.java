package com.bit;
class Ex04{
	public static void main(String[] args){
		int su1 =1;
		for(int i = 0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print(su1++);
				if(j==2)System.out.print("\n");
			}
			// if 대신 or System.out.print("\n");
				
		}
	}
}