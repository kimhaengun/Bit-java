package com.bit;

import java.util.ArrayList;

class Lotto{
	int lottoNum;
}

public class Ex11 {
	public static void main(String[] args) {
		
		ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
		
		
		
		int lottoNum ;
		int indNum=1;
		int count =1;
		boolean boo = true;
		
		while(boo) {
			if(count==5) {
				boo = false;
			}
			for (int i = 0; i < 5; i++) {
				Lotto lotto = new Lotto();
				lottoNum = (int)(Math.random()*45+1);
				lotto.lottoNum = lottoNum;
				lottoList.add(lotto);
				for (int j = 0; j < lottoList.size(); j++) {
					if(lottoList.get(i).lottoNum == lottoNum) {
						i--;
						break;
					}
				}
				
				
			}
			
//			for (int i = 0; i < lottoList.size(); i++) {
//				System.out.println(lottoList.get(i));
//			}
			
			int changNum = 0;
			for (int i = 1; i < lottoList.size(); i++) {
				for (int j = 0; j < lottoList.size(); j++) {
					if(lottoList.get(i).lottoNum<lottoList.get(j).lottoNum) {

						Lotto lotto = new Lotto();
						int i1 = lottoList.get(i).lottoNum;
						lotto.lottoNum = i1; 
						Lotto lotto2 = new Lotto();
						int j1 = lottoList.get(j).lottoNum;
						lotto2.lottoNum = j1;
						
						
						lottoList.set(i, lotto); //i = 42
						lottoList.set(j, lotto2); // i = 35
						

					}
				}
						
			}
			
			System.out.print(indNum+" 번호 : ");
			for (int i = 0; i < lottoList.size(); i++) {
				if(lottoList.get(i).lottoNum>=1 && lottoList.get(i).lottoNum <=9) {
					System.out.print("  "+"0"+lottoList.get(i).lottoNum+"  ");
				}else {
					System.out.print("  "+lottoList.get(i).lottoNum+"  ");
				}
				
			
			}
			System.out.println();
			count++;
			indNum++;
			lottoList.clear();
			
		}
				
	}
}
