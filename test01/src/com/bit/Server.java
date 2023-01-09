package com.bit;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Server {

	static String id, password;
	static ServerSocket serverSocket = null;
	static InputStream is = null;
	static OutputStream os = null;
	
	
	static ObjectInputStream ois = null;
	static ObjectOutputStream oos = null;
		
	static OutputStreamWriter osw = null;
	static PrintWriter pw = null;
	
	static InetAddress addr = null;
	
	//파일 관련
	static OutputStream fos = null;
	static ObjectOutputStream foos = null;
	static InputStream fis = null;
	static ObjectInputStream fois = null;
	
	public static void main(String[] args) {
		System.out.println("서버 실행");
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
//		Map<String, UserIn> userMap = new HashMap<String, UserIn>();
		
		File userFile = new File("userList.bin");
		
		
		try {
			serverSocket = new ServerSocket(8080);
			
			while(true) {
				System.out.println("요청 대기");
				final Socket socket = serverSocket.accept();
				
				System.out.println("요청 들어옴");
				Thread thr = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
							try {
								addr = socket.getInetAddress();
								is = socket.getInputStream();
								os = socket.getOutputStream();
								
								ois = new ObjectInputStream(is);
								oos = new ObjectOutputStream(os);
								
								osw = new OutputStreamWriter(os);
								
								pw = new PrintWriter(osw);
								
								fos = new FileOutputStream(userFile);
								foos = new ObjectOutputStream(fos);
								
								fis = new FileInputStream(userFile);
								fois = new ObjectInputStream(fis);
								
								list.add(pw);
								System.out.println("addr : "+addr.getHostAddress());
								
								while(true) {
									
								HashMap<String, UserIn> ClientInfo =(HashMap<String, UserIn>)  ois.readObject();
								//회원가입
								if(ClientInfo.containsKey("join")) {
									id = ClientInfo.get("join").getUserId();
									password = ClientInfo.get("join").getUserPassword();
									System.out.println(id+" "+password);
									UserIn user = new UserIn(id, password);
									ArrayList<UserIn> userIn = new ArrayList<UserIn>();
									userIn.add(user);

									try {
										if(!userFile.exists()) {
											userFile.createNewFile();
										}
										//파일 로그인 쓰기
										foos.writeObject(userIn);
										
										PrintWriter w = new PrintWriter(oos);
										w.println("join Success");
										
										w.flush();
										System.out.println("회원가입 완료");

									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} //회원가입 end
								
								//로그인
								else if(ClientInfo.containsKey("login")) {
									System.out.println("로그인 요청");
									id = ClientInfo.get("login").getUserId();
									password = ClientInfo.get("login").getUserPassword();
									System.out.println(id+" "+password);
									ArrayList<UserIn> userList;
									try {
										System.out.println("회원 찾는중");
										userList = new ArrayList<UserIn>();   
										if(userFile.exists()) {
											
											System.out.println("파일은 있음");
											try {
												fis = new FileInputStream(userFile);
												fois = new ObjectInputStream(fis);
												userList = (ArrayList<UserIn>)fois.readObject();
								               } catch (EOFException e1) {
								                  // TODO Auto-generated catch block
								       
								               } catch (ClassNotFoundException e) {
								            // TODO Auto-generated catch block
								            	   e.printStackTrace();
								               }
											
											System.out.println("login : "+userList);
											
											if(userList == null) {
												System.out.println("회원이 없습니다.");
											}else {
												for (int i = 0; i < userList.size(); i++) {
													
													if( id.equals(userList.get(i).getUserId()) && password.equals(userList.get(i).getUserPassword()) ) {
														//id와 pw가 일치 하면
														System.out.println("회원 존재 함");
														break;
														}	
//													System.out.println("1id:"+userList.get(i).getUserId()+" pw:"+userList.get(i).getUserPassword());
//													System.out.println("2id:"+id+" pw:"+password);
												}
													
											}
										System.out.println("아아아아아아아악");	
										}else {
											//회원이 없을 경우
											System.out.println("회원 파일 존재 안함");
										}
										
										
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} //로그인 end
								
								
								}//while end
							} catch (IOException e) {
								// TODO Auto-generated catch block
								
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								
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
