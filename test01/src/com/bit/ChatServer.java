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
		// 메세지 리스트 담기
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
		ServerSocket serv = null;
		try {
			// 서버 열고
			serv = new ServerSocket(8081);
			while (true) {
				// 클라이언트 기다리고 소켓 얻기
				final Socket sock = serv.accept();
				// 소켓을 바탕으로 스레드 생성
				Thread thr = new Thread(new Runnable() {

					@Override
					public void run() {
						
						InputStream is = null;
						OutputStream os = null;

						InputStreamReader isr = null;
						OutputStreamWriter osw = null;

						BufferedReader br = null;
						PrintWriter pw = null;
						InetAddress addr = null;
						try {
						
							addr = sock.getInetAddress();

							is = sock.getInputStream();
							os = sock.getOutputStream();
							isr = new InputStreamReader(is);
							osw = new OutputStreamWriter(os);
							br = new BufferedReader(isr);
							pw = new PrintWriter(osw);
							list.add(pw);

							//클라이언트에서 받은 메시지 처리
							String c;
							while ((c = br.readLine()) != null) {
								System.out.println("c:" + c);
								// 채팅일 경우
								if (c.contains("-")) {
									System.out.println("CCCCCHHHHH");
									String[] chatarr = c.split("-");
									String chatm = chatarr[1];
									for (int i = 0; i < list.size(); i++) {
										PrintWriter cpw = list.get(i);
										cpw.println(chatm);
										cpw.flush();
									}
								} else {
									// 알람 = 입장 or 퇴장
									System.out.println("등장!!!!");
									String msg = null;// 클라이언트가 보낸 값 저장
									int count = list.size();
									if (c.contains("퇴장")) {
										list.remove(pw);
									}
									System.out.println("받은 메세지 : " + c + ", " + list.size());
									c += "," + list.size();
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
						} finally {
							try {
								if (pw != null)
									pw.close();
								if (br != null)
									br.close();
								if (osw != null)
									osw.close();
								if (isr != null)
									isr.close();
								if (os != null)
									os.close();
								if (is != null)
									is.close();
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
