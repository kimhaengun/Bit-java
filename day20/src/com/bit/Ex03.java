package com.bit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex03 {
	//문자열 처리에서만 사용할 수 있다.
	
	public static void main(String[] args) {
		File f = new File("test03.txt");
		Writer pw = null;
		char[] buff = "123456789asdwqdwqdwqdwqsdavbab".toCharArray();
			try {
				if(!f.exists())f.createNewFile();
				pw = new FileWriter(f);
				
//				for (int i = '가'; i <= '갛'; i++) {
					pw.write("한글이 된다 한글이 된다 된다 된다");
//				}
				
				
				if(pw!=null)pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
