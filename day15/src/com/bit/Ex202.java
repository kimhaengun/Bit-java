package com.bit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex202 {
	public static void main(String[] args) throws ParseException {
		// 100일 계산기
		// 년 >
		// 월 >
		// 일 >
		// 0000-01-01에서 100일 뒤는 0000-00-00입니다.
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 100일 계산기 ===");
		System.out.print("년 >");
		String inputYear = sc.nextLine();
		System.out.print("월 >");
		String inputMonth = sc.nextLine();
		System.out.print("일 >");
		String inputDate = sc.nextLine();
		
		String inputData = inputYear+inputMonth+inputDate;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(inputData);
		String result = sdf.format(date);
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		
		
		System.out.println(result+"에서 100일 뒤는 "+"입니다.");
		
	}
}
