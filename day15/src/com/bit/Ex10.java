package com.bit;

import java.util.Calendar;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal =  Calendar.getInstance();
		int before = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(2022, 12-1, 6);
		System.out.println(
					cal.get(Calendar.YEAR)+"년"
					+(cal.get(Calendar.MONTH)+1)+"월"
					+cal.get(Calendar.DATE)+"일"
					+cal.get(Calendar.HOUR)+"시"
				);
		int after = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(before-after+1);
		
		Calendar cal2 = Calendar.getInstance();//현재
		System.out.println(cal2.before(cal)); //cal 기준 현재가 이전 
		System.out.println(cal2.after(cal));
		System.out.println(cal2.compareTo(cal2));

	}

}
