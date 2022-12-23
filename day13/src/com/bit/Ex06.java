package com.bit;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex06 {
	public static void main(String[] args) {
		java.util.List list;
		list = new ArrayList();
		list = new LinkedList();
		
		java.util.Queue que;
		que = new LinkedList();
		que.offer(1111);
		que.offer(2222);
		que.offer(3333);
		que.offer(4444);
		
		// poll() = 하나씩 가져옴 
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		// 더 이상 가져올 값없으면 null
//		System.out.println(que.poll());
		
		// peek(); 가지고 오지 않고 바라만봄...
//		System.out.println(que.peek()); //1111
//		que.poll(); //1111을 가지고 와서 2222가 남음
//		System.out.println(que.peek()); //1111 //poll 실행 시 2222
//		System.out.println(que.peek()); //1111 //poll 실행 시 2222
		
		while(que.peek()!=null) {
			System.out.println(que.peek());
			System.out.println(que.peek());
			System.out.println(que.peek());
			que.poll();
		}
//		int count=0;
//		while(que.peek()!=null) {
////			System.out.println(++count);
//			System.out.println(que.poll());
////			System.out.println(que.poll());
//			}
	}
}


