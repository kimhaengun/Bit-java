package com.bit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream.GetField;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Ex01 {

	public static void main(String[] args) {
		ServerSocket serv = null;
		Socket sock = null;
		
		System.out.println("서버 준비...");
		OutputStream os = null;
		File f = new File("target.jpg");
		
			try {
				serv = new ServerSocket(8080);
				while(true) {
				//icon 전달...
				
//				sock = serv.accept();
//				System.out.println("첫번째 요청");
//				sock.close();
				sock = serv.accept();
				System.out.println("두번째 요청");
//				SocketAddress addr = sock.getRemoteSocketAddress();
//				InetSocketAddress addr2 = (InetSocketAddress)addr;
//				
//				System.out.println(addr2.getHostString());
//				System.out.println("접속됨");
				os = sock.getOutputStream();
				os.write("HTTP/1.1 200 OK\r\n".getBytes());
//				os.write("Content-Type: text/prain\r\n".getBytes());
//				os.write("Content-Type: text/html; cahrset=utf-8\r\n".getBytes());
				os.write("Content-Type: image/jpg;\r\n".getBytes());
				os.write("\r\n".getBytes());			
//				os.write("<h1>abdcdsfq<h1>".getBytes());
				
				InputStream is = new FileInputStream(f);
				
				int su =-1;
				while((su=is.read())!=-1) {
					os.write(su);
				}
				
				is.close();
				os.close();
				sock.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
