/*
 2. 변수
    1. static변수 - 클래스 변수
    2. non-static변수 - [멤버]필드
static -> static                메서드명(); --> [클래스명.]메서드명();  ex) func1();
static -> non-static          참조변수.메서드명(); ex) ex04.func01();
non-static -> static          메서드명(); --> [클래스명.]메서드명();  ex) func01();
non-static -> non-static    메서드명(); --> [참조변수.]메서드명();  ex) func01();

*/

/*
class Ex05{
	// 전역 변수의 특성
	// 초기화 없이 사용 가능
	// default 값 존재
            // default 값을 사용하든, 
	public static int su1 =111;
	public int su2 = 222;
	// =====================
	
	public void func01(){
		System.out.println("func01 : "+su1);
		su1++;
		System.out.println("func01 : "+su2);
	}

	public static void main(String[] args){
		su1 = 333;
		System.out.println(su1);
		Ex05 ex05 = new Ex05();
		System.out.println(ex05.su2);
		System.out.println("==========");
		ex05.func01();
		System.out.println("==========");
		System.out.println("main su1 : "+su1);			
	}
}
*/

class Ex05{
	public static int su1 =111;
	public int su2 = 222;
	// =====================
	
	public void func01(){
		System.out.println("func01 : "+su2);
	}

	public static void main(String[] args){
		
		Ex05 ex05;
		for(int i =0; i<5; i++){
			ex05 = new Ex05();
			ex05.su2++;
			ex05.func01();
		}
	}
}
