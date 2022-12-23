package com.bit;
/*
 * Point
 * 배열은 배열 복사를 통해서 add 로직을 수행한다고 한다면 point는 
 * value에 다른 값의 주소를 포함하고 있기 때문에 연결되어 있다.
 * ------------------------------------------------
 * 값을 찾는 과정은
 * 배열은 4바이트 라는 일정한 단위로 저장되어 있기때문에 찾기 쉽지만
 * point는 메모리가 빈공간에 할당되어 있기 떄문에 (heap공간에 서로 연결은 되어 있지만 흩어져있음)
 * 해당 값을 찾기 위해서는 연결된 point를 따라 ex) 만개의 point가 있을 경우 메모리 상에 흩어져 있는 포인트를 따라 만번을  찾아야함 (공간 낭비 심함, 탐색이 느림)
 * 
 * 자바에서 배열의 성능은 뛰어나지만 생산성에 있어서는 별로
 * 
 */

class Node{
	int val;
	Node nxt;
}

class Arr2{
	Node first;
	int count = 0;
	int size() {
		return count;
	}
	int get(int idx) {
		//start.val;
		//start.nxt.val;
		//start.nxt.nxt.val;
		Node temp = first;
		for(int i=0; i<idx; i++) {
			temp=temp.nxt;
		}
		return temp.val;
	}
	void add(int su) {
		//1.
//		Node node = new Node();
//		node.val=su;
//		first=node;
		////
		//2.
//		Node node2 = new Node();
//		node2.val=su;
//		first.nxt = node2;
		////
		//3.
//		Node node3 = new Node();
//		node3.val = su;
//		first.nxt.nxt = node3;
		count++;
		Node node = new Node();
		node.val = su;
		if(count==1) {
			first = node;
		}else {
			Node temp = first;
			while(true) {
				if(temp.nxt==null)break;
				temp = temp.nxt;
			}
			temp.nxt=node;
//			temp.nxt = temp;
			
		}
		
	}
}


public class Ex03 {
	public static void main(String[] args) {
		Arr2 arr = new Arr2();
		arr.add(1111);
		arr.add(2222);
		arr.add(3333);
		arr.add(4444);
		for (int i = 0; i < arr.count; i++) {
			System.out.println(arr.get(i));
		}
	}
}
