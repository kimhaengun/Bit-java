package com.step04;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
/*
 * 다중 사용자 채팅
 */
public class Server {

	public static void main(String[] args) {
		//7.메세지 리스트 담기
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
		ServerSocket serv = null;
		try {
			//1. 서버 열고
			serv = new ServerSocket(8080);
			while(true) {
				//2.클라이언트 기다리고 소켓 얻기
				final Socket sock = serv.accept();
				//3. 소켓을 바탕으로 스레드 생성
				Thread thr = new Thread(new Runnable() {
					
					@Override
					public void run() {
						//4.메시지 받고 쓸 준비
						InputStream is = null;
						OutputStream os = null;
						
						InputStreamReader isr = null;
						OutputStreamWriter osw = null;
						
						BufferedReader br = null;
						PrintWriter pw = null;
						InetAddress addr = null;
						try {
							//6. sock(클라이언트) 정보 받기
							addr = sock.getInetAddress();
							
							is=sock.getInputStream();
							os = sock.getOutputStream();
							isr = new InputStreamReader(is);
							osw = new OutputStreamWriter(os);
							br = new BufferedReader(isr);
							pw = new PrintWriter(osw);
							list.add(pw);
							
							//5.클라이언트로 부터 받은 메시지 읽기
							String msg = null;
							while((msg=br.readLine())!=null) {
								msg="["+addr.getHostAddress()+"]"+msg;
								for (int i = 0; i < list.size(); i++) {
									PrintWriter w = list.get(i);
									w.println(msg);
									w.flush();									
								}
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
							} catch (IOException e2) {
								// TODO: handle exception
							}
						}
						
					}
				});
				thr.start();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
