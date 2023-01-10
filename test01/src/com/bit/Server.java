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
	static File userFile;
	public static void main(String[] args) {
		System.out.println("서버 실행");
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
		
		try {
			serverSocket = new ServerSocket(8080);
			
			while(true) {
				System.out.println("요청 대기");
				final Socket socket = serverSocket.accept();
				
				System.out.println("요청 들어옴");
				Thread thr = new Thread(new Runnable() {
					
					@Override
					public void run()  {
						// TODO Auto-generated method stub
							try {
								addr = socket.getInetAddress();
								is = socket.getInputStream();
								os = socket.getOutputStream();
								
								ois = new ObjectInputStream(is);
								oos = new ObjectOutputStream(os);
								
								osw = new OutputStreamWriter(os);
								
								pw = new PrintWriter(osw);
								
								//파일 관련 객체
								userFile= new File("userList.bin");							
								
								ArrayList<UserIn> users;
//								list.add(pw);
								System.out.println("addr : "+addr.getHostAddress());
								
								while(true) {
									
						            File f = new File("userList.txt");
						            users = new ArrayList<UserIn>();
						            // txt파일에서 회원 가져오기
						            if(f.exists()) {
						               try {
						                  fis = new FileInputStream(f);
						                  fois = new ObjectInputStream(fis);
						                  users = (ArrayList<UserIn>)fois.readObject();
											for (int i = 0; i < users.size(); i++) {
											System.out.println(users.get(i).getUserId());
											System.out.println(users.get(i).getUserPassword());
											
										}
						               } catch (EOFException e1) {
						                  // TODO Auto-generated catch block
						       
						               } catch (ClassNotFoundException e) {
						            	   // TODO Auto-generated catch block
						            	   e.printStackTrace();
						               } 
						            }
									System.out.println("시작");

								HashMap<String, UserIn> ClientInfo =(HashMap<String, UserIn>)  ois.readObject();
								
								//회원가입
								if(ClientInfo.containsKey("join")) {
									id = ClientInfo.get("join").getUserId();
									password = ClientInfo.get("join").getUserPassword();
									System.out.println(id+" "+password);
									UserIn user = new UserIn(id, password);
									ArrayList<UserIn> userIn = new ArrayList<UserIn>();
									userIn.add(user);
									fos = new FileOutputStream(f);
									foos = new ObjectOutputStream(fos);
									try {
										if(users!=null) {
											
											users.add(user);
											
											//파일 로그인 쓰기
											foos.writeObject(users);
//											foos.flush();
											
											foos.close();
										}else {
											f.createNewFile();
											foos.writeObject(userIn);
//											foos.flush();
											foos.close();																						
										}
									PrintWriter w = new PrintWriter(oos);
									w.println("join Success");
										
									w.flush();
									System.out.println("회원가입 완료");
									foos.close();
									fos.close();
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
									boolean boo = false;
									if(userFile.exists()) {
										for (int i = 0; i < users.size(); i++) {
													
											if( id.equals(users.get(i).getUserId()) && password.equals(users.get(i).getUserPassword()) ) {
												//id와 pw가 일치 하면
												System.out.println("회원 존재 함");
												boo = true;
												break;
											}	
										}
										if(boo==true) {
											//회원 존재
											System.out.println("if 회원존재");
											PrintWriter w = new PrintWriter(oos);
											w.println("login Success");
											w.flush();
										}else {
											//회원 없음
											System.out.println("if 회원x");
											
											PrintWriter w2 = new PrintWriter(oos);
											w2.println("login Fail");
											w2.flush();
										}
										
									}else {
											//회원이 없을 경우
										System.out.println("회원 파일 존재 안함");
									}
								} //로그인 end
								else if(ClientInfo.containsKey("chat")) {
									System.out.println("메ㅔㅔ세세세셋세세세세세세세세세지지지지지지지지짖지지");
								}
								
								HashMap<String, ChatInfo> chatInfo =(HashMap<String, ChatInfo>)  ois.readObject();
								if(chatInfo.containsKey("chat")) { //채팅 시작 시
									
								}
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
