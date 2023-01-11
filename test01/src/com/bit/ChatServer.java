package com.bit;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
/*
 * 다중 사용자 채팅
 */
public class ChatServer {

	public static void main(String[] args) {
		System.out.println("챗 서버 도는중");
		//7.메세지 리스트 담기
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
		ServerSocket serv = null;
		try {
			//1. 서버 열고
			serv = new ServerSocket(8081);
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
							String c;
							while((c=br.readLine()) != null) {
								System.out.println("c:"+c);
								// 클라이언트가 보낸 메시지 처리
								if(c.contains("-")) {
									System.out.println("CCCCCHHHHH");
									String[] chatarr = c.split("-");
									String chatm = chatarr[1];
									for (int i = 0; i < list.size(); i++) {
										PrintWriter cpw = list.get(i);
										cpw.println(chatm);
										cpw.flush();
									}
								}else {
									// 입장 관련
									System.out.println("등장!!!!");
									String msg;// 클라이언트가 보낸 값 저장
									
									System.out.println("받은 메세지 : " + c + ", " + list.size());
									for (int i = 0; i < list.size(); i++) {
										PrintWriter cpw = list.get(i);
										cpw.println(c);
										cpw.flush();
										
									}
									
								}
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
