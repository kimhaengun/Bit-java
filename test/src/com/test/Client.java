package com.test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
	Socket clientSock;
	public Client() {
		// TODO Auto-generated constructor stub
		String url = "127.0.0.1";
		int port =8080;

		try {
			clientSock = new Socket(url,port);
//			
//			UserInfo userInfo = new UserInfo("khu", "1234");
//			Map<String, UserInfo> user = new HashMap<String, UserInfo>();
//			user.put("join", userInfo);
//			
//			OutputStream os = null;
//			ObjectOutputStream oos =null;
//			os = clientSock.getOutputStream();
//			oos = new ObjectOutputStream(os);
//			
//			oos.writeObject(user);
//			
//			oos.close();
//			os.close();
			
			System.out.println("Cli : "+clientSock);
			new LoginForm(clientSock);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		 new Client();
	}
}
