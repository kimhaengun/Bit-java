package com.bit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex130 {
	public static void main(String[] args) {
//		Set lotto = new HashSet();
		Set lotto = new TreeSet();
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45)+1);
			System.out.println(lotto);
		}
		Iterator ite = lotto.iterator();
		while(ite.hasNext()) System.out.print(ite.next()+" ");
	}
}
