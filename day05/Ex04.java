class Ex04{
	/*
	  static -> static                메서드명(); --> [클래스명.]메서드명();  ex) func1();
	  static -> non-static          참조변수.메서드명(); ex) ex04.func01();
	  non-static -> static          메서드명(); --> [클래스명.]메서드명();  ex) func01();
	  non-static -> non-static    메서드명(); --> [참조변수.]메서드명();  ex) func01();
	*/
	public static void func1(){
		System.out.println("Ex04 func1() 입니다.");
	}

	public static String str1(String str){
		String result = "어어어어엉어엉";
		return result;
	}

	public void func01(){
		System.out.println("non-static method func01()");
	}

	public void func02(){
		System.out.println("non-static method func02()");
		func01();
	}

	public static void main(String[] args){
		String msg1 = "AA";
		java.lang.String msg2 = "BB";
		java.lang.System.out.println(msg1);
		System.out.println(msg2);	
		
		java.util.Scanner sc;
		String result = str1("아아앙아아아아아");
		System.out.println(result);
		func1();
		Ex05.func1();
		Ex04 ex04 = new Ex04();
		ex04.func01();
		ex04.func02();
	}
}


class Ex05{
	public static void func1(){
		System.out.println("Ex05 func1() 입니다.");
	}
}