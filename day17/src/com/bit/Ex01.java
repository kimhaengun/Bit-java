package com.bit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "abcdefg hijklmn";
		byte[] buf = new byte[2];
		File f = new File("lec01.bin");
		OutputStream os;
		
		try {
			//쓰기
			if(!f.exists()) {
				f.createNewFile();
			}
			os = new FileOutputStream(f);
			
			for (int i = 0; i < msg.length(); i+=2) {
				buf[i] = (byte)msg.charAt(i);
				
				
			}
			os.write(buf);
			os.close();
			System.out.println("작성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
