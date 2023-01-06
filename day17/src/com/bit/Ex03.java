package com.bit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/*
 * BufferedOutputStream으로 쓰기
 */
public class Ex03 {
	public static void main(String[] args) {
		String msg = "ABCDEFG HIJKLMN";
		File f= new File("lec03.bin");
		
		OutputStream os= null;
		BufferedOutputStream bos=null;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			os = new FileOutputStream(f);
			bos = new BufferedOutputStream(os);
			for (int i = 0; i < msg.length(); i++) {
				bos.write(msg.charAt(i));
			}
			
			//쓰기할 때 close 안하면 내용 다날아감
			if(bos!=null) {
				bos.close();
			}
			if(os!=null) {
				os.close();
			}
			System.out.println("end");
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
