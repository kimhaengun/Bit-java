package com.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Ex10 {

	public static void main(String[] args) {
		//문자열로 변환
		OutputStream os = null;
		Writer osw=null;
		
		try {
			os = new FileOutputStream("test08.txt");
			osw = new OutputStreamWriter(os);
			
			osw.write("문자열 작성");
			
			if(osw!=null)osw.close();
			if(os!=null)os.close();
			System.out.println("작성완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
