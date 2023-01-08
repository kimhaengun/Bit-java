package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

	public static void main(String[] args) {
		System.out.println("서버 실행");
		ServerSocket serverSocket = null;
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
		Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
		try {
			serverSocket = new ServerSocket(8080);
			while(true) {
				final Socket socket = serverSocket.accept();
				System.out.println("요청 들어옴");
				Thread thr = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						InputStream is = null;
						OutputStream os = null;
						
						ObjectInputStream ois = null;
						ObjectOutputStream oos = null;
						
						InetAddress addr = null;
						
						try {
							addr = socket.getInetAddress();
							is = socket.getInputStream();
							os = socket.getOutputStream();
							
							ois = new ObjectInputStream(is);
							oos = new ObjectOutputStream(os);
							System.out.println("=========");
							HashMap<String, UserInfo> ClientInfo =(HashMap<String, UserInfo>)  ois.readObject();
							
							System.out.println("?");
							if(ClientInfo.containsKey("join")) {
								System.out.println("??");
								String id = ClientInfo.get("join").getUserId();
								String pw = ClientInfo.get("join").getUserPassword();
								System.out.println(id+" "+pw);
								
							}
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							
						}finally {
							try {
								if(oos!=null)oos.close();
								if(ois!=null)ois.close();
								if(os!=null)os.close();
								if(is!=null)is.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						
						
					}//run() end
				});
				thr.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
