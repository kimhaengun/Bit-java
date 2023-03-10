package com.step01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/*
 * Client 소켓 생성시 필요한것
 * 1.주소
 * 2.포트번호
 * Client = InputStream
 */
public class Client {

	public static void main(String[] args) {
		//ip주소
		byte[] arr= {(byte)192,(byte)168,(byte)240,97};
		InetAddress addr = null;
		int port = 8080;
		//소켓을 사용하기 위해서는 addr, port 객체가 필요함
		Socket sock = null;
		
		//서버에서 온 데이터 읽기
		InputStream is = null;
		//클라이언트에서 서버로 데이터 보내기
		OutputStream os = null;
		
		try {
			addr = InetAddress.getByAddress(arr);
			//sock 객체 생성 = 접속
			// client, server모두 sock을 열면 서로 다른 객체 이기 떄문에 한곳 만 열고 
			sock = new Socket(addr,port);
			is = sock.getInputStream();
			os = sock.getOutputStream();

//			os.write(65);
//			os.write(66);
//			os.write(67);
//			System.out.println(is.read());
//			System.out.println(is.read());
//			System.out.println(is.read());
			
			//클라이언트에서 서버로 데이터 보내기
			os.write("Hi Server ..".getBytes());
			
			//1. 서버에서 받은 메시지 뿌리기
			int su = -1;
			while((su=is.read())!='.') { //'.' = .을 만나면 종료하겠다는 선언    == end의 기준점
				System.out.print((char)su);				
			}
			

			
			
			if(os!=null)os.close();
			if(is!=null)is.close();
			if(sock!=null)sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
