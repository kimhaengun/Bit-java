package com.bit;
/*
	로또 번호 생성기 
	1~45번의 숫자 6개의 숫자가 나옴
	
*/
public class Ex10 {
	public static void main(String[] args) {
		int[] lottoList = new int[6];
		int rottoNum;
		boolean boo = true;
		int count = 1;
		int indNum = 1;
		while(boo) {
			//5번 반복
			if(count==5) {
				boo = false;
			}
			
			for (int i = 0; i < 6; i++) {
				rottoNum = (int)(Math.random()*45+1);
				
					lottoList[i] = rottoNum;
				
				for (int j = 0; j < i; j++) {
					if(lottoList[j] == rottoNum) {
						
						i--;
						break;
					}
				}
				
				
			}
			//리스트 출력
//			for (int i = 0; i < lottoList.length; i++) {
//				System.out.println(lottoList[i]);
//			}
			int changNum = 0;
			for (int i = 1; i < lottoList.length; i++) {
				for (int j = 0; j < lottoList.length; j++) {
					if(lottoList[i]<lottoList[j]) {
						changNum = lottoList[i];
						lottoList[i] =lottoList[j];
						lottoList[j] = changNum;
					}
				}
						
			}
			System.out.print(indNum+" 번호 : ");
			for (int i = 0; i < lottoList.length; i++) {
				if(lottoList[i]>=1 && lottoList[i] <=9) {
					System.out.print("  "+"0"+lottoList[i]+"  ");
				}else {
					System.out.print("  "+lottoList[i]+"  ");
				}
			
			}
			System.out.println();
			indNum++;
			count++;
			
			
			
		}
		

	}
}
