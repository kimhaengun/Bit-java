package com.bit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력해주세요");
		String msg = sc.nextLine();
		System.out.println("입력 받은 문자열 : "+msg);
		
		
		// 주민번호 체크(ver 0.1.0)
		// 주민번호 >991231-2345678
		// 당신은 00 살 여성입니다.
		
		// 주민번호 > 9912312345678
		// 입력확인 바랍니다 ex)000000-0000000
		
		// 주민번호 > 991231-234567
		// 입력확인 바랍니다 (앞자리6개 뒷자리7개 입니다.)

		// 주민번호 > 991231-a34567
		// 입력확인 바랍니다 (숫자를 입력바랍니다.)
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("===주민번호 체크(ver 0.1.0)");
		System.out.print("주민번호 > ");
		String inputNum = sc.nextLine();
		
//		System.out.println("받은 번호 : "+inputNum);
		boolean boo = true;
		String gender ;
		
		while (boo) {
			// 조건 1. 받은 문자열에  - 검사 
			if(inputNum.contains("-")) {
				
				String[] splitDataArray = inputNum.split("-");
//				System.out.println(splitDataArray[0].substring(0, 2));
//				System.out.println(splitDataArray[1].substring(0, 1));
				
				String inputYearNum = splitDataArray[0].substring(0, 2);
				String genderNum = splitDataArray[1].substring(0,1);
				
				int year = 2022;

				
				// 조건 2. 문자열에 - 가 있고 주민번호 갯수 검사
				if(splitDataArray[0].length() < 7 && splitDataArray[1].length() < 7) {
					// 주민번호 갯수 안맞음
					int firstArrayNum = splitDataArray[0].length();
					int secondArrayNum = splitDataArray[1].length();
					
					System.out.println("입력확인 바랍니다 (앞자리"+firstArrayNum+"개 뒷자리"+secondArrayNum+"개 입니다.)");
					boo = false;
					}else { 

					// 조건 3. 문자열에 - 가 있고 주민번호 갯수 정상적이고 문자열 검사
					if(!(splitDataArray[0].matches("[-+]?\\d*\\.?\\d+") && splitDataArray[0].matches("[-+]?\\d*\\.?\\d+"))) {
						String year0Num = splitDataArray[0].substring(0, 1);
						
						if(year0Num.equals("0")) {
							//year 0~ 년생
							inputYearNum = "20"+inputYearNum;
						}else {
							// 19년생
							inputYearNum = "19"+inputYearNum;
						}
						int intInputYearNum = Integer.parseInt(inputYearNum);
						int userYear = (year - intInputYearNum)+1;
						
						//조건 4. 문자열에 - 가 있고 주민번호 갯수 정상적이고 정상적인 주민번호를 입력한 경우
						if(genderNum.equals("1")) {
							gender = "남";
							System.out.println("당신의 나이는 : "+userYear+"살 "+gender+ "입니다.");	
							boo = false;
						}else if(genderNum.equals("2")) {
							gender = "여";
							System.out.println("당신의 나이는 : "+userYear+"살 "+gender+ "입니다.");
							boo = false;
						}else {
							System.out.println("성별을 확인할 수 없습니다.");
							boo = false;
						}
				
						// 조건4 if 종료					
					}else {
						
						System.out.println("입력확인 바랍니다 (숫자를 입력바랍니다.)");
						boo = false;						
						
					} // 조건3 if 종료
					
				} //조건2 if 종료
				

				
			}else {
				System.out.println("입력확인 바랍니다 ex)000000-0000000");
				boo = false;
			} //조건1 if 종료

					
			
		} // end while
		

	}

}
