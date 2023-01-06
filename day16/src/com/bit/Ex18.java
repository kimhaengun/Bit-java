package com.bit;

import java.io.*;

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File target = new File("Lec16.bin"); //읽기
		File result = new File("Lec18.txt"); //쓰기
		
		byte[] buf = new byte[10];
		InputStream is;
		OutputStream os;
		
		// 그림일 경우
		// target = logo.jpg
		// result = copu.jpg
			try {
				if(!result.exists()) {
					result.createNewFile();
				}
					is = new FileInputStream(target);
					os = new FileOutputStream(result);
				
					while(true) {
						int su = is.read(buf);
						if(su == -1)break;
						os.write(su);
				
					}
					is.close();
					os.close();
					System.out.println("복사 완료");
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}


