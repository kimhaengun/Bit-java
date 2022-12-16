class Ex08{
	public static void main(String[] args){
		char ch1= 'A';
		System.out.println(ch1);

		String str1="ABCD";
		System.out.println(str1);

		System.out.println("ch1 : "+ch1+" + str1 : "+str1+ " = " +ch1+str1);
		System.out.println("문자열 : "+str1+" + 문자열 : "+str1+ " = " +str1+str1);
		
		String str2 = str1+str1;
		System.out.println(str2);

		String str3 = str1+5;
		System.out.println("문자열+정수 = 문자열 --> " +str3);

		String str4 = 5+5+str1;
		System.out.println("(정수+정수)+문자열 = 문자열 --> " +str4);				

		String str5 = str1+5+5;
		System.out.println("(문자열+정수)+정수 = 문자열 --> " +str5);				

	} 
}

