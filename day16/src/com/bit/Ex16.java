package com.bit;

import java.io.*;
/*
 *    -->OutputStream
 *   나                            파일
 *    InputStream<--
 */
public class Ex16 {

	public static void main(String[] args) {
		// String일 경우 byte 배열에 담아서 사용해야함.
		String msg = "한";
		byte[] arr = msg.getBytes();
		File f = new File("Lec16.bin");
		// 1. OutputStream 생성
		OutputStream os;
		try {
			if(!f.exists())f.createNewFile(); 
			os = new FileOutputStream(f); //쓸 준비 끝~
			// 2. 쓰기
			// 쓰는 순간 기존에 데이터가 있으면 데이터를 날리고 새로운 쓰는 데이터가 들어감 (*조심*)
			// 쓸때는 바이너리 데이터 (숫자)로 전달됨.
//			os.write(65); // 쓰는거는 byte 단위
//			os.write(66); // 쓰는거는 byte 단위
//			os.write('가'); // 쓰는거는 byte 단위
//			for (int i = 0; i < arr.length; i++) {
//				os.write(arr[i]);
//			}
			os.write('a');
			os.write('b');
			os.write('c');
			os.write('d');
			
			/////////////////////////////////////
			
			// 3. I/O = 닫아줘야함
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
