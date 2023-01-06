package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex02 {

	public static void main(String[] args) {
		InetAddress[] inets = null; 
		try {
			inets = InetAddress.getAllByName("www.naver.com");
			for (int i = 0; i < inets.length; i++) {
				System.out.println(inets[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
