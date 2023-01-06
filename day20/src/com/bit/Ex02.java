package com.bit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/*
 * 이전 파일의 기존 데이터를 담기 위해 copy txt를 만들고 안에 기존 데이터와 동일한 값을 넣어 놓고 가져옴.
 *  = 하드디스크 공간에 파일을 또 생성해서 저장하기 때문에 성능이 느림
 *  
 * ByteArrayInput,OutputStream은 하드디스크 공간에 값을 저장하는 것이 아닌 자료 구조와 같이 메모리 공간에 저장하기 때문에 성능이 빠름
 *  
 * 
 */
public class Ex02 {

	public static void main(String[] args) {
		
		File f = new File("test01.txt");
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		try {
			is = new FileInputStream(f);
			baos = new ByteArrayOutputStream();
			
			int su = -1;
			while((su=is.read())!=-1) {
				baos.write(su);
			}
			byte[] arr = baos.toByteArray();
			bais = new ByteArrayInputStream(arr);
			
			su=-1;
			while((su=bais.read())!=-1) {
				System.out.println(su);
			}
			
			
			System.out.println(new String(arr));
			if(baos!=null)baos.close();
			if(is!=null)is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
