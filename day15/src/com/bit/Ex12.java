package com.bit;

import java.util.Date;

public class Ex12 {
	public static void main(String[] args) {
		java.util.Date dat;
		dat = new Date(1020178800000L); //2002년 5월1일
		System.out.println(dat);
		
//		dat.setYear(2002-1900);
//		dat.setMonth(6-1);
		
		System.out.println(dat.getYear()+1900); //1900년 기준
		System.out.println(dat.getMonth()+1);
		System.out.println(dat.getDate());
		System.out.println(dat.getHours());
		System.out.println(dat.getMinutes());
		System.out.println(dat.getSeconds());
	}
}
