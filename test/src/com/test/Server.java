package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

	static String id, pw;
	public static void main(String[] args) {
		System.out.println("서버 실행");
		ServerSocket serverSocket = null;
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
		Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
		
		File userFile = new File("userList.bin");
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
							HashMap<String, UserInfo> ClientInfo =(HashMap<String, UserInfo>)  ois.readObject();
							//회원가입
							if(ClientInfo.containsKey("join")) {
								System.out.println("회원가입 요청");
								userJoin(ClientInfo);	
							} //회원가입 end
							
							//로그인
							if(ClientInfo.containsKey("login")) {
								System.out.println("로그인 요청");
								userLogin(ClientInfo);
							}//로그인 end
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
					
					
					private void userLogin(HashMap<String, UserInfo> clientInfo) {
						// TODO Auto-generated method stub
						id = clientInfo.get("login").getUserId();
						pw = clientInfo.get("login").getUserPassword();
						System.out.println(id+" "+pw);
						
						InputStream is = null;
						ObjectInputStream ois = null;
						boolean boo = false;
						try {
							if(userFile.exists()&&(userFile.length()>0)) {
								is = new FileInputStream(userFile);
								ois = new ObjectInputStream(is);
								ArrayList<UserInfo> userList = (ArrayList<UserInfo>)ois.readObject();
								for (int i = 0; i < userList.size(); i++) {
									if( userList.get(i).getUserId()==id && userList.get(i).getUserPassword()==pw ) {
										//id와 pw가 일치 하면
										System.out.println("회원 존재 함");
										boo = true;
									}
								}
								if(boo == true) {
									System.out.println("찾았는데 있음");
								}else {
									 System.out.println("찾았는데 없음");
								}
							}else {
								//회원이 없을 경우
								System.out.println("회원 정보 존재 안함");
							}
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							try {
								if(ois!=null)ois.close();
								if(is!=null)is.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}


					//회원가입
					private void userJoin(HashMap<String, UserInfo> clientInfo) {
						// TODO Auto-generated method stub
						id = clientInfo.get("join").getUserId();
						pw = clientInfo.get("join").getUserPassword();
						System.out.println(id+" "+pw);
						UserInfo user = new UserInfo(id, pw);
						ArrayList<UserInfo> userIn = new ArrayList<UserInfo>();
						userIn.add(user);
						OutputStream os = null;
						ObjectOutputStream oos =null;
						try {
							if(!userFile.exists()) {
								userFile.createNewFile();
							}
							os = new FileOutputStream(userFile);
							oos = new ObjectOutputStream(os);
							
							oos.writeObject(userIn);
							
							System.out.println("회원가입 완료");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally {
							try {
								if(oos!=null)oos.close();
								if(os!=null)os.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} //userJoin end
					
				});
				thr.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
