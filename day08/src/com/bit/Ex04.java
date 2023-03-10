package com.bit;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcabcdefg";
		//String 문자열 줄 원하는 인덱스의 값을 가져옴 = charAt()
		System.out.println(str.charAt(0)); // a 
		System.out.println(str.charAt(str.length()-1));
		
		// 해당 문자열이 포함되어 있는지 = contains()
		System.out.println(str.contains("cdf")); 
		System.out.println(str.contains("CDF"));
		
		//문자열 검사 --> startsWith(), endsWith()
		System.out.println(str.startsWith("ab"));
		System.out.println(str.endsWith("fg"));
		
		//문자열 index 값 가져오기 = indexOf()
		System.out.println(str.indexOf('d'));
		//만약 a가 둘 이상일 경우 맨처음 값의 인덱스만 출력된다.
		System.out.println(str.indexOf('a'));
		System.out.println(str.indexOf("bc"));
		//만약 str 문자열에 해당 문자('A')가 없을 경우 -1 return
		System.out.println(str.indexOf('A'));
		
		//문자열이 비어 있는지
		System.out.println("".isEmpty());
		System.out.println("".length()==0);

		//sub 해당 인덱스 번호부터 끝까지 return
//		String str2 = str.substring(3);
//		System.out.println(str2); // dafg
		
		String str2 = str.substring(7,9);
		System.out.println(str2); //ef
		
		//모든 문자 바꾸기 = replace()
//		String st5=str.replace('a', 'A');
//		System.out.println(st5);
		
		String st5=str.replace("ABC", "abc");
		System.out.println(st5);
		
		// 무엇이든 수행해도 결과 값을 return 할 뿐 본질의 값은 항상 유지된다.
		System.out.println(str);
		
		
		
	}

}
