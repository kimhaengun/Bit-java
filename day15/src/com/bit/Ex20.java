package com.bit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex20 {
	public static void main(String[] args) throws ParseException {
		// 100일 계산기
		// 년 >
		// 월 >
		// 일 >
		// 0000-01-01에서 100일 뒤는 0000-00-00입니다.
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 100일 계산기 ===");
		System.out.print("년 >");
		int inputYear = sc.nextInt();
		System.out.print("월 >");
		int inputMonth = sc.nextInt();
		System.out.print("일 >");
		int inputDate = sc.nextInt();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar beforeCal = new GregorianCalendar(inputYear,inputMonth-1,inputDate);
		Date beforeDate = beforeCal.getTime();
		String beforeResult = sdf.format(beforeDate);
		
		
		
		Calendar afterCal = new GregorianCalendar(inputYear,inputMonth-1,inputDate+99);
		Date afterDate = afterCal.getTime();
		String afterResult = sdf.format(afterDate);
		
		System.out.println(beforeResult+"에서 100일 뒤는 "+afterResult+"입니다.");
		
//		Date d = new Date(inputYear-1900,inputMonth-1,inputDate);
//		long before = d.getTime();
//		//100일 뒤
//		before+=1000L*60L*60L*24L*100L;
//		Date d2 = new Date(before);
//		System.out.println(d);
//		System.out.println(d2);
		
		
	}
}
