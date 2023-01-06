package com.bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * auto close
 * close를 알아서 해줌
 * JDK 1.8 이상
 */
public class Ex09 {

	public static void main(String[] args) {
		try(
			//수행 구문, 변수선언 할 수 없음
			//Closeable 인터페이스를 상속받는 문법만 작성 가능
			//try 안에서 일어난 I/O만 자동으로 close해줌
			Reader fr = new FileReader("test07.txt");
			BufferedReader br = new BufferedReader(fr);
				
			)
		{
			String msg = null;
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
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
