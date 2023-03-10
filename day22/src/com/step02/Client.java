package com.step02;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/*
 * 클라이언트에서 메시지 보내고 서버로부터 읽기
 */
public class Client {

	public static void main(String[] args) {
		String url="127.0.0.1";
		int port = 8080;
		Socket sock = null;
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			sock = new Socket(url,port); //접속 완료
			is = sock.getInputStream();
			os = sock.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);
			String msg = null;
			while(true) {
				System.out.print("메시지 >");
				msg = sc.nextLine();
				if(msg.equals("end"))break;
				pw.println(msg);
				//buffer가 꽉 찰때까지 밀어내지 않기 떄문에 밀어내 줘야함..
				//메시지 보낼 시 flush 필수 !!! = buffer 밀어내기
				pw.flush();
				msg = br.readLine();
				System.out.println(msg);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pw!=null)pw.close();
				if(br!=null)br.close();
				if(osw!=null)osw.close();
				if(isr!=null)isr.close();
				if(os!=null)os.close();
				if(is!=null)is.close();
				if(sock!=null)sock.close();				
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		
		
		
		
		
	}
}
