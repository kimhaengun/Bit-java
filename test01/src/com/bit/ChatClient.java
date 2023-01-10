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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ChatClient extends Frame implements ActionListener{
	static Socket sock;
	static String userId;
	
	static TextArea ta = new TextArea();
	static TextField tf = new TextField();
	static PrintWriter pw;
	static InputStream is = null;
	static OutputStream os = null;
	static InputStreamReader isr = null;
	static OutputStreamWriter osw = null;
	static BufferedReader br = null;
	static ObjectOutputStream oos =null;
	ChatInfo chatInfo;
	public ChatClient(Socket sock, String userId) {
		// TODO Auto-generated constructor stub
		ChatClient.sock = sock;
		ChatClient.userId = userId;
		System.out.println("char"+userId);
		new ChatClient();
	}
	
	public ChatClient() {
		
		try {
			is = sock.getInputStream();
			os = sock.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);
			
//			String msg = null;
//			
//			while(true) {
//				System.out.print("메시지 >");
//				
//				//buffer가 꽉 찰때까지 밀어내지 않기 떄문에 밀어내 줘야함..
//				//메시지 보낼 시 flush 필수 !!! = buffer 밀어내기
//				msg = br.readLine();
//				if(msg.equals("exit"))break;
//				System.out.println(msg);
//				//읽어온 메시지 textArea에 뿌리기
//				ta.append(msg+"\n");
//			}
			
			setLayout(new BorderLayout());
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			
			Panel p = new Panel();
			p.setLayout(new BorderLayout());
			JLabel userIdLb = new JLabel();
			JLabel userListLb = new JLabel();
			JButton exitBtn = new JButton("채팅 나가기");
			userIdLb.setText("참여자 : "+userId);
			p.add(userIdLb,BorderLayout.NORTH);
			p.add(exitBtn, BorderLayout.SOUTH);
			tf.addActionListener(this);
			add(ta,BorderLayout.CENTER);
			add(p,BorderLayout.EAST);
			add(tf,BorderLayout.SOUTH);
			
			setBounds(100, 100, 500, 300);
			setVisible(true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("dddddddddddddd");
		System.out.println(sock);
		String msg = tf.getText();
		UserIn chatInfo = new UserIn(userId, msg);
		Map<String, UserIn> chat = new HashMap<String, UserIn>();
		chat.put("chat", chatInfo);
		try {
			oos.writeObject(chat);
			oos.flush();
			tf.setText("");
			tf.setText("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(msg);
	}
	
}
