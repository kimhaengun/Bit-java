package com.bit;

import java.io.*;

public class Ex02 {

	public static void main(String[] args) {
		File f = new File("lec01.bin");
		File copy = new File("copy.bin");
		byte[] buf = new byte[1];
		InputStream is=null;
		OutputStream os = null;
			try {
				//읽기
				if(f.exists()) {
					is = new FileInputStream(f);
					if(!copy.exists()) {
						copy.createNewFile();
					}
					os = new FileOutputStream(copy);
					
					while(true) {
						int su = is.read(buf); // 읽어온 값은 buf에 담기고 su는 몇개의 버퍼를 불러왔는지 나타내준다.
						if(su==-1) {
							break;
						}
						os.write(buf,0,su);
					}
				}
				
				if(is!=null) {
					is.close();
				}
				if(os!=null) {
					os.close();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
