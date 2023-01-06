package com.bit;

import java.util.*;

public class Ex16 {
	public static void main(String[] args) {
		java.io.InputStream is = System.in;
		Scanner sc;
		sc = new Scanner("12\nefg");
		System.out.println(sc.hasNextInt());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		
//		sc = new Scanner("12\n34");
//		System.out.println(sc.nextInt()+1);
//		System.out.println(sc.next()+1);
		
		// sc.next, sc.hasNext 위주로 흘러간다고 생각하면됨...
		// 여기서 확장된게 nextLine, nextInt
		
	}
}
