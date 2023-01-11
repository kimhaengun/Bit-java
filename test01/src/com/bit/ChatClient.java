package com.bit;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
/*
 * 클라이언트에서 메시지 보내고 서버로부터 읽기
 */
public class ChatClient extends Frame implements ActionListener{
	static TextArea ta = new TextArea();
	static TextField tf = new TextField();
	static PrintWriter pw;
	static String userId;
	
	
	String url="127.0.0.1";
	int port = 8081;
	Socket sock = null;
	InputStream is = null;
	OutputStream os = null;
	InputStreamReader isr = null;
	OutputStreamWriter osw = null;
	BufferedReader br = null;
	ChatClient cc;
	
	public ChatClient(String userId) {
		System.out.println("넘어온 아이디 : "+userId);
		this.userId = userId;
		System.out.println("받은 아이디 : "+this.userId);
		cc = new ChatClient();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = "chat-"+userId + ":" + tf.getText();
		System.out.println("클라이언트 작성 글 : " + msg);
		
		pw.println(msg);
		pw.flush();
		tf.setText("");
		tf.setText("");
	}
	public ChatClient() {


		try {
			sock = new Socket(url,port); //접속 완료
			is = sock.getInputStream();
			os = sock.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);
			
			//접속시 클라이언트들에게 입장 메시지 띄우기
			
			String joinAlr = "*알림!      " + userId + "님이 입장 했습니다.*";
			pw.println(joinAlr);
			pw.flush();
			
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			setLayout(new BorderLayout());
			Panel p = new Panel();
			p.setLayout(new BorderLayout());
			JLabel userIdLb = new JLabel();
			JLabel userListLb = new JLabel();
			JButton exitBtn = new JButton("채팅 나가기");
			userIdLb.setText("참여자 : " + userId);
			exitBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String exitAlr = "*알림!      " + userId + "님이 퇴장하셨습니다.*";
					pw.println(exitAlr);
					pw.flush();
					dispose();
				}
			});
			
			p.add(userIdLb, BorderLayout.NORTH);
			p.add(exitBtn, BorderLayout.SOUTH);
			
			
			add(ta,BorderLayout.CENTER);
			add(p,BorderLayout.EAST);
			add(tf,BorderLayout.SOUTH);

			tf.addActionListener(this);
			
			setBounds(100, 100, 500, 300);
			setVisible(true);
			Thread th = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
			while(true) {
				//buffer가 꽉 찰때까지 밀어내지 않기 떄문에 밀어내 줘야함..
				//메시지 보낼 시 flush 필수 !!! = buffer 밀어내기
				String msg;
				try {
					msg = br.readLine();
					System.out.println(msg);
					//읽어온 메시지 textArea에 뿌리기
					ta.append(msg+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
					
				}
			});
			th.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			try {
//				if(pw!=null)pw.close();
//				if(br!=null)br.close();
//				if(osw!=null)osw.close();
//				if(isr!=null)isr.close();
//				if(os!=null)os.close();
//				if(is!=null)is.close();
//				if(sock!=null)sock.close();				
//			}catch (IOException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}

		}

	}




}
