package com.bit;

public class Ex07 {
	void func() {
		System.out.println("func()~");
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object obj = new Object();
		Class cls1 = obj.getClass();
		Class cls2 = Object.class;
		System.out.println(cls1);
		System.out.println(cls2);
		
		Ex07 me = new Ex07();
		Class cls3 = me.getClass();
		Class cls4 = Ex07.class;
		
		//패키지
		Class cls5 = Class.forName("com.bit.Ex07");
		// new와 같은 기능 ,  Ex07 obj2 = new Ex07();
		Ex07 obj2 = (Ex07)cls5.newInstance();
		System.out.println(obj2);
		
		obj2.func();
		
	}
}
