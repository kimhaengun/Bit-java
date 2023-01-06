package com.bit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex07 {

	public static void main(String[] args) {
		Writer fw=null;
		PrintWriter pw = null; //print = 문자열로 작성
		try {
			fw = new FileWriter("test07.txt"); //무조건 덮어씌움.. new를 안했기 때문에 파일이 있고 없고의 어떠한 조건의 기능을 할 수 없음
			pw = new PrintWriter(fw);
			
			pw.print(true);
			pw.print(1234);
			pw.print(3.24);
			pw.println();
			pw.println("문자열 메시지 작성");
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(pw!=null)pw.close();
					if(fw!=null)fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
	}
}
