package com.bit;

import java.util.Calendar;

public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		System.out.println(cal.get(Calendar.WEEK_OF_MONTH)); //1년중 몇일 지났나
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR)); //현재 올해에서 몇주차인지
		 
			
	}

}
