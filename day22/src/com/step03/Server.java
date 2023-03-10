package com.step03;

import java.io.*;
import java.net.*;

public class Server extends Thread{
	Socket sock;
	public Server(Socket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//socket으로 I/O작업해주기
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = sock.getInputStream();
			os = sock.getOutputStream();
			while(true) {
				//읽기
				int su = is.read();
				if(su==-1)break;
				//쓰기
				os.write(su);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os!=null)os.close();
				if(is!=null)is.close();	
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}

	}
	public static void main(String[] args) {
		ServerSocket serve = null;
		
		try {
			//다중 사용자를 받기위한 무한 루프
			serve = new ServerSocket(8080);
			while(true) {
				//accept는 계속 실행하면서 다중 사용자를 받을 수 있는 sock이 있어야함.
				Socket sock = serve.accept();
				Server me = new Server(sock);
				me.start();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
