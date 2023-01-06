package com.bit;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex06 {

	public static void main(String[] args) {
		File f = new File("lec06.bin");
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			os = new FileOutputStream(f);
			dos = new DataOutputStream(os);
			
			dos.write(65);
			dos.writeInt(1234);
			dos.writeDouble(3.14);
			dos.writeChar('가');
			dos.writeBoolean(true);
			dos.writeUTF("한글로 문자열");
			
			
			if(dos!=null)dos.close();
			if(os!=null)os.close();
			System.out.println("end");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
