package com.bit;

class Ball{
	private static int cnt=0;
	final int num;
	boolean marking;
	//노, 파, 빨, 검, 초
	String color;
	
	Ball(){
		cnt++;
		num = cnt;
		if(num < 11) {
			color="노랑";
		}else if(num<21) {
			color="파랑";
		}else if(num<31) {
			color="빨강";
		}else if(num<41) {
			color="검정";
		}else{
			color="초록";
		}
		
	}
}
public class Ex02 {
	public static void main(String[] args) {
		int limit = 45;
		Ball[] box = new Ball[limit];
		String[] note = new String[7];
		for (int i = 0; i < box.length; i++) {
			// 1~45 공담기
			box[i]= new Ball();
			
		}
		
		int cnt = 0;
		//노트에 받아 적기
		while(true) {
			int ran = 0;
			ran=(int)(Math.random()*limit);
			Ball ball = box[ran];
			if(!ball.marking) { //marking이 false일 경우
				note[cnt++]=ball.color+"색 공"+ball.num+"번";
				ball.marking=true;
			}
			if(cnt==note.length) {
				break;
			}
		}
		
		
//		for (int i = 0; i < 6-1; i++) {
//			for (int j = i+1; j < 6; j++) {
//				
//				if(note[i]>note[j]) {
//					int temp = note[i];
//					note[i]=note[j];
//					note[j]=temp;
//				}
//			}
//		}
		
		for (int i = 0; i < note.length; i++) {
			if(i==note.length-1) {
				System.out.print("보너스 :");
			}			
			System.out.println(note[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < note.length; i++) {
			String num = note[i].replace("번", "")
			.substring(note[i].indexOf("색 공")+"색 공".length());
			
			if(i==note.length-1) {
				System.out.print(" + ");
			}
			System.out.print(Integer.parseInt(num)+" ");
		}
		
	}
}
