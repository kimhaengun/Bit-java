package com.bit;

//부모 생성자 
class Lec06{
	public Lec06(){
		super();
	}
	void func01() {
		System.out.println("부모 기능");
	}
}
public class Ex06 extends Lec06{
	
	public Ex06() {
		super();
		// 부모 생성자가 매개변수를 안받거나 ,default 있을 경우 명시 안해도됨.
		// default 생성자가 없을 경우 super 명시
	}
	
	public Ex06(int a) {
		this();
		
	}
	public Ex06(double a) {
		this();
		
	}
	public static void main(String[] args) {
		Ex06 ex06 = new Ex06();
		ex06.func01();
	}
}
