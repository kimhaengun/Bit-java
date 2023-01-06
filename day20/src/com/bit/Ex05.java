package com.bit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex05 {
	
	public static void main(String[] args) {
		File f = new File("test04.txt");
		Writer fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			bw.write("문자열을 버퍼를 이용해 작성할 예정입니다.");
			//일정 작업후 명시적으로 밀어낼 때 = /
			// 통신시 문자를 작성을 하고 flush를 해야 작성된 값(채팅)을 상대방에게 줄 수 있음 = 상대방이 메시지를 봐야할때
			bw.flush();
//			bw.write("\r\n");
			bw.newLine(); //개행
			bw.write("도 한줄 더 작성하겠습니다");
			
			
			if(bw!=null)bw.close();
			if(fw!=null)fw.close();
			System.out.println("작성완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
