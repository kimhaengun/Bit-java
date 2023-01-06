package com.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex11 {

	public static void main(String[] args) {
		InputStream is=null;
		Reader isr = null;
		
		try {
			is = new FileInputStream("test08.txt");
			isr = new InputStreamReader(is);
			int su = -1;
			while((su=isr.read())!=-1) {
				System.out.print((char)su);
			}
			
			
			if(isr!=null)isr.close();
			if(is!=null)is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
