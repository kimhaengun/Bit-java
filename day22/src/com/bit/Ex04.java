package com.bit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex04 {

	public static void main(String[] args) {
		File f = new File("weather.xml");
		URL url =null;
		InputStream is;
//		InputStreamReader isr=null;
//		BufferedReader br = null;
		
		OutputStream os = null;
		try {
//			fw = new FileWriter(f);
//			pw = new PrintWriter(fw);
			os = new FileOutputStream(f);
			url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=159");
			URLConnection conn = url.openConnection();
			is=conn.getInputStream();
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);
			
			
			
//			String msg = null;
			int msg = -1;
			while((msg=is.read())!=-1) {
//				pw.println(msg);
				os.write(msg);
			}
			
			
			System.out.println("크롤링 완료");
			

//			if(pw!=null)pw.close();
//			if(fw!=null)fw.close();
//			if(br!=null)br.close();
//			if(isr!=null)isr.close();
			if(is!=null)is.close();
			if(os!=null)os.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
