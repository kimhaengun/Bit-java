package com.bit;

import java.awt.BorderLayout;
import java.awt.Font;
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
public class ChatClient extends Frame implements ActionListener {
	static TextArea ta = new TextArea();
	static TextField tf = new TextField();
	static JLabel allCountJl = new JLabel();
	static PrintWriter pw;
	static String userId;
	static int allCount = 0;

	String url = "127.0.0.1";
	int port = 8081;
	Socket sock = null;
	InputStream is = null;
	OutputStream os = null;
	InputStreamReader isr = null;
	OutputStreamWriter osw = null;
	BufferedReader br = null;
	ChatClient cc;

	public ChatClient(String userId) {
//		System.out.println("넘어온 아이디 : "+userId);
		this.userId = userId;
//		System.out.println("받은 아이디 : "+this.userId);
		cc = new ChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = "chat-" + userId + ":" + tf.getText();
		System.out.println("클라이언트 작성 글 : " + msg);

		pw.println(msg);
		pw.flush();
		tf.setText("");
		tf.setText("");
	}

	public ChatClient() {

		try {
			sock = new Socket(url, port); // 접속 완료
			is = sock.getInputStream();
			os = sock.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);

			// 접속시 클라이언트들에게 입장 메시지 띄우기

			String joinAlr = "# 알림! " + userId + "님이 입장 했습니다.";
			pw.println(joinAlr);
			pw.flush();
			///////////////////////////////

			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});

			Panel p = new Panel();
			JLabel userIdLb = new JLabel();
			JButton exitBtn = new JButton("채팅 나가기");
			JLabel userListLb = new JLabel();

			setLayout(new BorderLayout());
			ta.setFont(new Font("Arial, Serif, Monospaced", Font.BOLD, 20));
			p.setLayout(new BorderLayout());
			userIdLb.setText("참여자 : " + userId);
			allCountJl.setText("현재 참여 인원 : " + allCount);

			p.add(userIdLb, BorderLayout.NORTH);
			p.add(allCountJl, BorderLayout.CENTER);
			p.add(exitBtn, BorderLayout.SOUTH);

			add(ta, BorderLayout.CENTER);
			add(p, BorderLayout.EAST);
			add(tf, BorderLayout.SOUTH);

			// 채팅 action
			tf.addActionListener(this);
			// 채팅 나가기 버튼 action
			exitBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String exitAlr = "# 알림! " + userId + "님이 퇴장하셨습니다.";
					pw.println(exitAlr);
					pw.flush();
					dispose();
				}
			});

			setBounds(100, 100, 500, 300);
			setVisible(true);

			// 채팅 or 알람 스레드
			Thread th = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					while (true) {
						// 읽어온 메시지 textArea에 뿌리기
						String msg;
						try {
							msg = br.readLine();
							System.out.println(msg);
							if (msg.contains("알림")) {
								// 알림 and 참여 인원
								String[] s = msg.split(",");
								ta.append(s[0] + "\n");
								allCountJl.setText("참여 인원 : " + s[1]);
							} else {
								// 채팅
								if (msg.contains(userId)) {
									System.out.println("내채팅임" + userId);
									// 내 채팅일 경우 userId = "나"로 병경
									msg = msg.replace(userId, "나");
									System.out.println("내채팅임" + msg);
									ta.append(msg + "\n");
								} else {
									// 다른 사용자 채팅
									System.out.println("남 채팅임");
									ta.append(msg + "\n");
								}
							}

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
		}

	}

}
