package com.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Lec11 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int su1 = 1111;
	transient int su2 = 2222; //이값은 보내지 않음..
	private int su3 = 3333; //접근 제한자
	
	//메소드는 serializable 대상이 아님
	public void func() {
		System.out.println("func run -"+su3);
	}
}

public class Ex11 {

	public static void main(String[] args) {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream("dat11.bin");
			oos = new ObjectOutputStream(os);
			Lec11 lec = new Lec11();
			oos.writeObject(lec);
			
			oos.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
