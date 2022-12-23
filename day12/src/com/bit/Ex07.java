package com.bit;

import java.util.Scanner;

/*
 * 		// 주민번호 체크(ver 0.1.0)
		// 주민번호 >991231-2345678
		// 당신은 00 살 여성입니다.
		
		// 주민번호 > 9912312345678
		// 입력확인 바랍니다 ex)000000-0000000
		
		// 주민번호 > 991231-234567
		// 입력확인 바랍니다 (앞자리6개 뒷자리7개 입니다.)

		// 주민번호 > 991231-a34567
		// 입력확인 바랍니다 (숫자를 입력바랍니다.)
 */
public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===주민번호 체크 (ver 0.2.0)");
		String[] ssNum = new String[13];
		String input ;
		int year = 2022;
		boolean boo = true;
		String gender;
		do {
			System.out.print("주민번호 > ");
			input = sc.nextLine();
			input.trim();
//			System.out.print(input.length());
			if(!(input.contains("-"))) { //-가 없을 경우
				System.out.println("입력확인 바랍니다 ex)000000-0000000");
			}else {
				//문자 계산
				if(input.length()!=14) {
					//14자리가 아닐 경우
					String[] splitStr = input.split("-");
					System.out.println("입력확인 바랍니다(앞자리 6개 뒷자리 7개 입니다.)"); 
					System.out.println("입력하신 수 앞자리 :"+splitStr[0].length()+" 뒷자리 :"+splitStr[1].length());
					
				}else {
					//문자열 계산
					try {
						String[] splitStr = input.split("-");
//						System.out.println(splitStr[0].substring(0,1));
//						System.out.println(splitStr[1].substring(0,1));
						
						//숫자 검열
						int firstNum = Integer.parseInt(splitStr[0]);
						int secondNum = Integer.parseInt(splitStr[1]);

						try {
							
							if( "1".equals(splitStr[1].substring(0,1)) || "2".equals(splitStr[1].substring(0,1)) ) {

									int userYear = Integer.parseInt("19"+splitStr[0].substring(0, 2));
									
									if("1".equals(splitStr[1].substring(0,1))) {
										gender="남";
										System.out.println("당신은 "+(year-userYear+1)+"살 "+gender+"입니다.");
									}else if("2".equals(splitStr[1].substring(0,1))) {
										gender="여";
										System.out.println("당신은 "+(year-userYear)+"살 "+gender+"입니다.");
									}


								
							}else if( "3".equals(splitStr[1].substring(0,1)) || "4".equals(splitStr[1].substring(0,1))){

									int userYear = Integer.parseInt("20"+splitStr[0].substring(0, 2));
									
									if("3".equals(splitStr[1].substring(0,1))) {
										gender="남";
										System.out.println("당신은 "+(year-userYear+1)+"살 "+gender+"입니다.");
									}else if("4".equals(splitStr[1].substring(0,1))) {
										gender="여";
										System.out.println("당신은 "+(year-userYear)+"살 "+gender+"입니다.");
									}
									

							}else {
								throw new Exception();
							}
							
							
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("올바른 형식의 주민번호가 아닙니다.");
						}
		
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("입력확인 바랍니다 (숫자를 입력바랍니다).");
					}
				}
			}
		}while(boo);
	}
}
