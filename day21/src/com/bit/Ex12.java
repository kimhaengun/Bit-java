package com.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;

public class Ex12 {

	public static void main(String[] args) {
		InputStream is = null;
		ObjectInputStream ois = null;
		try {
			is = new FileInputStream("dat11.bin");
			ois = new ObjectInputStream(is);
			Lec11 obj = (Lec11)ois.readObject();
			
			System.out.println(obj.su1);
			System.out.println(obj.su2);
//			System.out.println(obj.su3);
			obj.func();
			
			if(is!=null)is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
