package com.bit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Client extends Frame implements MouseListener, ActionListener {
	Socket clientSock;
	String url = "127.0.0.1";
	int port = 8080;
	// 로그인
	Panel northP, centerP, idP, pwP, loginStatusP, eastP, southP;
	JLabel northL, joinL, loginStatus;
	Label idL, pwL;
	TextField loginIdTf, loginPwTf;
	Button loginBtn;
	Dimension di;
	// 회원가입
	Dialog dia;
	Panel joinP, joinP1, joinP2;
	Label joinIdL, joinPwL;
	JButton joinBtn;
	TextField joinIdTf, joinPwTf;

	// 채팅

	String userId, userPassword;
//	ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
	static OutputStream os = null;
	static ObjectOutputStream oos = null;
	static InputStream is = null;
	static InputStreamReader isr = null;
	static BufferedReader br = null;
	static OutputStreamWriter osw = null;
	static PrintWriter pw;

	public Client() {
		// TODO Auto-generated constructor stub

		try {

			clientSock = new Socket(url, port);

			os = clientSock.getOutputStream();
			oos = new ObjectOutputStream(os);

			is = clientSock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			// string
			osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw);

			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
//					if(!change)dispose();
					dispose();
				}
			});

			init();
			setting();
			batch();

			// Listener
			joinL.addMouseListener(this);
			loginBtn.addActionListener(this);
			setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		new Client();

	}

	public void init() {
		// <로그인 창>
		// north
		northP = new Panel();
		northL = new JLabel();
		// center
		centerP = new Panel();
		idP = new Panel();
		idL = new Label("ID   :");
		loginIdTf = new TextField(30);
		pwP = new Panel();
		pwL = new Label("PW :");
		loginPwTf = new TextField(30);
		loginStatusP = new Panel();
		loginStatus = new JLabel();
		// east
		eastP = new Panel();
		di = new Dimension();
		di.width = 100;
		di.height = 60;
		loginBtn = new Button("LOGIN");
		// south
		southP = new Panel();
		joinL = new JLabel();

	}

	public void setting() {
		setTitle("로그인");
		setLayout(new BorderLayout());
		centerP.setLayout(new FlowLayout());
		loginBtn.setPreferredSize(di);
		joinL.setText("회원가입");
		northL.setText("");
		setBounds(700, 300, 500, 200);
	}

	public void batch() {
		northP.add(northL);
		idP.add(idL);
		idP.add(loginIdTf);
		pwP.add(pwL);
		pwP.add(loginPwTf);
		loginStatusP.add(loginStatus);
		centerP.add(idP);
		centerP.add(pwP);
//		centerP.add(loginStatusP);

		eastP.add(loginBtn);
		southP.add(joinL);
		add(northP, BorderLayout.NORTH);
		add(centerP, BorderLayout.CENTER);
		add(eastP, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// 회원가입 클릭 시 회원가입 폼 띄우기
		dia = new Dialog(this);
		dia.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
//				if(!change)dispose();
				dia.dispose();
			}
		});
		joinP = new Panel();
		joinP1 = new Panel();
		joinP2 = new Panel();
		joinIdL = new Label("ID   :");
		joinIdTf = new TextField(30);

		joinPwL = new Label("PW :");
		joinPwTf = new TextField(30);
		joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(this);
		dia.setTitle("회원가입");

		joinP.setLayout(new BorderLayout());

		joinP1.add(joinIdL);
		joinP1.add(joinIdTf);
		joinP1.add(joinPwL);
		joinP1.add(joinPwTf);
		joinP2.add(joinBtn);

		joinP.add(new JLabel(" "), BorderLayout.NORTH);
		joinP.add(joinP1, BorderLayout.CENTER);
		joinP.add(joinP2, BorderLayout.SOUTH);

		dia.add(joinP);
		dia.setBounds(800, 330, 300, 150);
		dia.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// 회원가입 텍스트에 올라올때 색상 변경
		joinL.setForeground(new Color(80, 188, 223));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// 회원가입 텍스트에서 빠져나갈때 색상 복구
		joinL.setForeground(new Color(0, 0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("aP:"+e.getActionCommand());
		System.out.println("aP:" + e.getActionCommand());

		if (e.getActionCommand().equals("회원가입")) { // 회원가입 Action

			userId = joinIdTf.getText();
			userPassword = joinPwTf.getText();
			UserIn userInfo = new UserIn(userId, userPassword);
			Map<String, UserIn> userJoinInfo = new HashMap<String, UserIn>();
			userJoinInfo.put("join", userInfo);

			try {

				oos.writeObject(userJoinInfo);
				oos.flush();
				String serverMsg = br.readLine();
				System.out.println(serverMsg);
				if (serverMsg.contains("join Success")) {
					System.out.println("Cli : join Success");

					dia.dispose();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} // 회원가입 action end

		if (e.getActionCommand().contentEquals("LOGIN")) { // 로그인 Action

			System.out.println("로그인~~");
			userId = loginIdTf.getText();
			userPassword = loginPwTf.getText();
			System.out.println(userId + " " + userPassword);
			UserIn userInfo = new UserIn(userId, userPassword);
			Map<String, UserIn> userLoginInfo = new HashMap<String, UserIn>();
			userLoginInfo.put("login", userInfo);

			try {
				oos.writeObject(userLoginInfo);
				oos.flush();
				String serverMsg = br.readLine();
				System.out.println("로그인 결과 : " + serverMsg);
				if (serverMsg.contains("login Success")) {
					System.out.println("Cli : login Success / " + serverMsg);
//						dispose();
					this.setVisible(false);
					System.out.println(clientSock);
//						new ChatClient(clientSock,userId);

					// 채팅
					chat();

				} else {
					System.out.println("Cli : login Fail / " + serverMsg);
					northL.setText("해당 사용자가 없습니다.");
					northL.setForeground(Color.red);
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} // 로그인 Action end

	}

	private void chat() {
		// TODO Auto-generated method stub

		String alr = userId+"님이 입장 했습니다.";
		pw.println(alr);
		pw.flush();
		
		
		Dialog chat = new Dialog(this);

		chat.setLayout(new BorderLayout());
		chat.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				chat.dispose();
			}
		});

		TextArea ta = new TextArea();
		TextField tf = new TextField();
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		JLabel userIdLb = new JLabel();
		JLabel userListLb = new JLabel();
		JButton exitBtn = new JButton("채팅 나가기");
		userIdLb.setText("참여자 : " + userId);
		p.add(userIdLb, BorderLayout.NORTH);
		p.add(exitBtn, BorderLayout.SOUTH);
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//						String msg = tf.getText();
//						ChatInfo chatInfo = new ChatInfo(userId, msg);
//						Map<String, ChatInfo> chat = new HashMap<String, ChatInfo>();
//						chat.put("chat", chatInfo);
//						try {
//							oos.writeObject(chat);
//							oos.flush();
//							tf.setText("");
//							tf.setText("");
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
				//메세지 작성
				Thread chatThr = new Thread(new Runnable() {

					@Override
					public synchronized void run() {
						// TODO Auto-generated method stub
						String msg = userId + ":" + tf.getText();
						System.out.println("클라이언트 작성 글 : " + msg);
						pw.println(msg);
						pw.flush();
						tf.setText("");
						tf.setText("");
					}
				});
				chatThr.start();
			}
		});

		chat.add(ta, BorderLayout.CENTER);
		chat.add(p, BorderLayout.EAST);
		chat.add(tf, BorderLayout.SOUTH);

		chat.setBounds(100, 100, 500, 300);
		chat.setVisible(true);

//				String chatInUser = "";
//				chatInUser = userId;
//				pw.println();
//				pw.flush();
		
		// 채팅 접속 알림
		Thread thr = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						String s = br.readLine();
						System.out.println(s);
						ta.append(s + "\n");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		thr.start();
	}

}