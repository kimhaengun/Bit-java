package com.step01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
/*
 * 서버는 Sock 객체를 생성하지 않고 Client socket 객체를 반환 받아야함
 * Server = OutputStram
 */
public class Server {

	public static void main(String[] args) {
		Socket sock = null;
		ServerSocket serve=null;
		InetAddress inet = null;
		OutputStream os =null;
		
		//클라이언트에서 보낸 메시지 읽기
		InputStream is = null;
		try {
			serve = new ServerSocket(8080); //Client와 소통할 수 있도록 포트 번호 열어놔야함
			sock = serve.accept(); //클라이언트 접속 대기 / 클라이언트 들어오면 sock 반환
//			inet = sock.getInetAddress(); //요청온 클라이언트 정보 받기
//			System.out.println(inet.getHostAddress()+Arrays.toString(inet.getAddress())+"클라이언트 요청 받음");
			
			//서버에서 클라이언트로 메시지
			os = sock.getOutputStream();
//			os.write("Hello Client ...".getBytes());
			
			//클라이언트에서 받은 메시지
			is = sock.getInputStream();
			int su =-1;
			while((su=is.read())!=-1) {
//				System.out.print((char)su);
				//클라이언트로 부터 받은 메시지 다시 토스
				os.write(su);
			}
			
			if(is!=null)is.close();
			if(os!=null)os.close();
			if(sock!=null)sock.close();
			if(serve!=null)serve.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
