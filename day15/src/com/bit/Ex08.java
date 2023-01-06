package com.bit;

import java.util.Calendar;

public class Ex08 {
	public static void main(String[] args) {
		//날짜
		long time = System.currentTimeMillis();
		System.out.println(time);
		Calendar cal;
		cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(0));
		System.out.println(cal.get(1)); //년
		System.out.println(cal.get(2));
		System.out.println(cal.get(3));
		System.out.println(cal.get(4));
		System.out.println(cal.get(5)); //일
		System.out.println("===============");
		
		//컴퓨터 상에서 "월"은 0~11월로 표현 하기 때문에 +1해줘야함ㅁ
		while(true) {
			try {
				new Thread().sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cal = Calendar.getInstance();
			System.out.println(cal.get(Calendar.YEAR)+"년");
			System.out.println(1+cal.get(Calendar.MONTH)+"월");
			System.out.println(cal.get(Calendar.DATE)+"일");
			switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				System.out.println("일요일");
				break;
			case Calendar.MONDAY:
				System.out.println("월요일");
				break;
			case 3:
				System.out.println("화요일");
				break;
			case 4:
				System.out.println("수요일");
				break;
			case 5:
				System.out.println("목요일");
				break;
			case 6:
				System.out.println("금요일");
				break;
			case 7:
				System.out.println("토요일");
				break;

			default:
				break;
			}
			
			switch (cal.get(Calendar.AM_PM)) {
			case Calendar.AM:
				System.out.println("AM");
				break;
			case Calendar.PM:
				System.out.println("PM");				
				break;

			default:
				break;
			}
			System.out.println(cal.get(Calendar.AM_PM)*12+cal.get(Calendar.HOUR)+"시"); //오전 : AM_PM, 오후 : AP_PM
			System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시");
			System.out.println(cal.get(Calendar.MINUTE)+"분");
			System.out.println(cal.get(Calendar.SECOND)+"초");
		}

		
	}
}
