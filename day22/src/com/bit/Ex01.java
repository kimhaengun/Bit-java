package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		InetAddress addr1 = null;
//		byte[] arr1 = {(byte)192,(byte)168,(byte)240,(byte)97};
		byte[] arr1 = {127,0,0,1};
		System.out.println(Arrays.toString(arr1));
		try {
			addr1 = InetAddress.getByName("localhost");
//			addr1 = InetAddress.getByAddress(arr1);
			// naver - 223.130.195.200
			//ip = ipV4 - 1byte*4
			//DNS -  도메인을 활용해서 
			// 1.DNSㅅ버에 돔
			System.out.println(addr1.getHostName());
			//해당 IP 주소를 가지고 올 수 있음
			System.out.println(addr1.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
