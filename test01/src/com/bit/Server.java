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
	static ArrayList<UserIn> users;
	public static void main(String[] args) {
		System.out.println("서버 실행");
		ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();
//		Map<String, UserIn> userMap = new HashMap<String, UserIn>();
		
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
								
								fos = new FileOutputStream(userFile);
								foos = new ObjectOutputStream(fos);
								
								fis = new FileInputStream(userFile);
								fois = new ObjectInputStream(fis);
								

								list.add(pw);
								System.out.println("addr : "+addr.getHostAddress());
								
								while(true) {
									System.out.println("시작");
									if(userFile.exists()) {
										try {
											users = (ArrayList<UserIn>)fois.readObject();
											for (int i = 0; i < users.size(); i++) {
												System.out.println(users.get(i).getUserId());
												System.out.println(users.get(i).getUserPassword());
												
											}
											
										} catch (Exception e) {
											// TODO: handle exception
										}
									}else {
										System.out.println("안에 데이터가 없음");
									}
//									System.out.println("끝 "+users.size()); //null pofint 뜸
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
										if(users!=null) {
											
											users.add(user);
											
											//파일 로그인 쓰기
											foos.writeObject(users);
											foos.flush();
											
										}else {
											userFile.createNewFile();
											foos.writeObject(userIn);
											foos.flush();
																						
										}
										PrintWriter w = new PrintWriter(oos);
										w.println("join Success");
										
										w.flush();
										System.out.println("회원가입 완료");
									
//										if(w!=null)w.close();
//										if(foos!=null)foos.close();
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
//													System.out.println("1id:"+userList.get(i).getUserId()+" pw:"+userList.get(i).getUserPassword());
//													System.out.println("2id:"+id+" pw:"+password);
										}
										if(boo==true) {
											//회원 존재
											PrintWriter pw = new PrintWriter(oos);
											pw.write("login Success");
											pw.flush();
										}else {
											//회원 없음
											PrintWriter pw = new PrintWriter(oos);
											pw.write("login Fail");
											pw.flush();
										}
										boo = false;
									}else {
											//회원이 없을 경우
										System.out.println("회원 파일 존재 안함");
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
