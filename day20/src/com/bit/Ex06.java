package com.bit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex06 {
	
	public static void main(String[] args) {
		File f = new File("test07.txt");
		Reader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			int su = -1;
//			while((su = fr.read())!=-1) {
//				System.out.print((char)su);
//
//			}
			//특정 단위 짤라오기 = 개행 짜르기
//			System.out.print(br.readLine()); // 개행 전까지 읽어옴
//			System.out.print(br.readLine()); // 개행 전까지 읽어옴
//			System.out.print(br.readLine()); // 개행 전까지 읽어옴 / 끝줄 값이 없으면 null
			
			String msg=null;
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
			}
			
			
			if(br!=null)br.close();
			if(fr!=null)fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
