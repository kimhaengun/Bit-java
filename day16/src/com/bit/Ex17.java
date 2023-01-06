package com.bit;

import java.io.*;
/*
 *    -->OutputStream
 *   나                            파일
 *    InputStream<--
 */
public class Ex17 {

	public static void main(String[] args) {
		File f = new File("Lec16.bin");
		// 1. InputStream 객체 생성
		InputStream is;
		if(f.exists()) {
			try {
				is = new FileInputStream(f);
				// 2. 읽기
				//문자의 끝은 -1 --> int 로 받았기 떄문에 0~258으로 받고 더 이상 읽을게 없으면 -1출력
				
				int su = -1;
				while(true) {
					su = is.read();
					if(su==-1) {
						break;
					}
					System.out.println(su);
				}

				// 3. I/O 시 무조건 닫아줘야함
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
