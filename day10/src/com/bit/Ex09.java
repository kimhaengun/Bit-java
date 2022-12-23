//package com.bit;
//
//import java.util.Scanner;
//
//// 자바의 장점
//// 4. 인터페이스
//interface Marchine{
//	void on();
//	void off();
//	abstract void work();
//}
//
//class Tv implements Marchine{
//	public void on() {
//		System.out.println("켜다");
//	}
//	public void off() {
//		System.out.println("끄다");
//	}
//
//	public void work() {
//		System.out.println("방송 주파수를 잡아 화면과 소리를 출력해준다.");
//	}
//}
//
//class Radio implements Marchine{
//	
//	public void work() {
//		System.out.println("주파수를 잡아 소리를 들려준다.");
//	}
//
//	@Override
//	public void on() {
//		// TODO Auto-generated method stub
//		System.out.println("켜다");
//	}
//
//	@Override
//	public void off() {
//		// TODO Auto-generated method stub
//		System.out.println("끄다");
//	}
//}
//
//class Audio implements Marchine{
//	@Override
//	public void on() {
//		// TODO Auto-generated method stub
//		System.out.println("켜다");
//	}
//
//	@Override
//	public void off() {
//		// TODO Auto-generated method stub
//		System.out.println("끄다");
//	}
//	@Override
//	public void work() {
//		// TODO Auto-generated method stub
//		System.out.println("음악을 들려준다.");
//	}
//	
//}
//
//public class Ex09{
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("1.tv 2.radio 3.Audio > ");
//		int input = sc.nextInt();
//		Marchine mar = null;
//		if(input == 1) {
//			mar = new Tv();
//			
//		}else if(input == 2) {
//			mar =new Radio();
//		
//		}else if(input == 3) {
//			mar = new Audio();
//		}
//		
//		mar.on();
//		mar.work();
//		mar.off();			
//		
//	}
//}
