package com.bit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Ex08 {
	public static void main(String[] args) {
//		PrintStream out = System.out;
		File f = new File("lec06.bin");
		OutputStream os = null;
		PrintStream ps = null;
		try {
			os = new FileOutputStream(f);
			ps = new PrintStream(os);
			
			//PrintStram은 모두 문자열 처리
			ps.write(12);
			ps.print(4234);
			ps.print(4.14);
			ps.print('한');
			ps.print(false);
//			ps.print("abcdefg");
			
			
			if(ps!=null)ps.close();
			if(os!=null)os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
