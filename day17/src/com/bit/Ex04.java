package com.bit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/*
 * BufferedInputStream 읽기
 */
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("lec03.bin");
		InputStream is=null;
		BufferedInputStream bis = null;
		
		try {
			if(f.exists()) {
				is = new FileInputStream(f);
				bis = new BufferedInputStream(is);
				while (true) {
					int su = bis.read();
					if(su==-1)break;
					System.out.print((char)su);
					
				}
			}
			
			if(bis!=null) bis.close();
			if(is!=null) is.close();
			System.out.println("\nend");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
