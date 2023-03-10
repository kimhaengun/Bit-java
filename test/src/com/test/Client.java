package com.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Client extends Frame implements MouseListener,ActionListener{
	Socket clientSock;
	//로그인
	Panel northP, centerP, idP, pwP, eastP, southP;
	JLabel northL, joinL;
	Label idL, pwL;
	TextField loginIdTf, loginPwTf;
	Button loginBtn;
	Dimension di;
	//회원가입
	Dialog dia;
	Panel joinP, joinP1, joinP2;
	Label joinIdL, joinPwL;
	JButton joinBtn;
	TextField joinIdTf,joinPwTf;
	
	String userId,userPassword;
//	ArrayList<UserInfo> userList = new ArrayList<UserInfo>();

	public Client() {
		// TODO Auto-generated constructor stub
		String url = "127.0.0.1";
		int port =8080;

		try {
			clientSock = new Socket(url,port);
			clientSock.setSoTimeout(30000);
			
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
			//Listener
			joinL.addMouseListener(this);
			loginBtn.addActionListener(this);
			setVisible(true);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		 new Client();
	}
	
	
	public void init() {
		//<로그인 창>
		//north
		northP = new Panel();
		northL = new JLabel("이미지 들어갈 예정");
		//center
		centerP = new Panel();
		idP = new Panel();
		idL = new Label("ID   :");
		loginIdTf = new TextField(30);
		pwP = new Panel();
		pwL = new Label("PW :");
		loginPwTf = new TextField(30);
		//east
		eastP = new Panel();
		di = new Dimension();
		di.width = 100;
		di.height = 60;
		loginBtn = new Button("LOGIN");
		//south
		southP = new Panel();
		joinL = new JLabel();
		
		
	}
	
	public void setting() {
		setTitle("로그인");
		setLayout(new BorderLayout());
		centerP.setLayout(new FlowLayout());
		loginBtn.setPreferredSize(di);	
		joinL.setText("회원가입");
		
		setBounds(700, 300, 500, 200);
	}
	public void batch() {
		northP.add(northL);
		idP.add(idL);
		idP.add(loginIdTf);
		pwP.add(pwL);
		pwP.add(loginPwTf);	
		centerP.add(idP);
		centerP.add(pwP);

		eastP.add(loginBtn);
		southP.add(joinL);
		add(northP,BorderLayout.NORTH);
		add(centerP,BorderLayout.CENTER);
		add(eastP,BorderLayout.EAST);
		add(southP,BorderLayout.SOUTH);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//회원가입 클릭 시 회원가입 폼 띄우기
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
		joinP1  = new Panel();
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
		
		joinP.add(new JLabel(" "),BorderLayout.NORTH);
		joinP.add(joinP1,BorderLayout.CENTER);
		joinP.add(joinP2,BorderLayout.SOUTH);
		
		dia.add(joinP);
		dia.setBounds(800, 330, 300, 150);
		dia.setVisible(true);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//회원가입 텍스트에 올라올때 색상 변경
		joinL.setForeground(new Color(80,188,223));
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
		//회원가입 텍스트에서 빠져나갈때 색상 복구
		joinL.setForeground(new Color(0,0,0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals("회원가입")) { //회원가입 Action
			userJoin();

		} //회원가입 action end
		
		if(e.getActionCommand().contentEquals("LOGIN")) { //로그인 Action
			System.out.println("로그인~~");
			userId = loginIdTf.getText();
			userPassword = loginPwTf.getText();
			System.out.println(userId+" "+userPassword);
			UserIn userInfo = new UserIn(userId, userPassword);	
			Map<String, UserIn> userLoginInfo = new HashMap<String, UserIn>();
			userLoginInfo.put("login", userInfo);
			OutputStream os = null;
			ObjectOutputStream oos =null;
			try {	
				
					os = clientSock.getOutputStream();
					oos = new ObjectOutputStream(os);					
					
					oos.writeObject(userLoginInfo);
	
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
//			dispose();
//			new MainForm();
		} //로그인 Action end
	}

	//회원가입
	private void userJoin() {
		// TODO Auto-generated method stub
		userId = joinIdTf.getText();
		userPassword = joinPwTf.getText();
		UserIn userInfo = new UserIn(userId, userPassword);		
		Map<String, UserIn> userJoinInfo = new HashMap<String, UserIn>();
		userJoinInfo.put("join", userInfo);
		OutputStream os = null;
		ObjectOutputStream oos =null;
		try {	
			
				os = clientSock.getOutputStream();
				oos = new ObjectOutputStream(os);					
				
				oos.writeObject(userJoinInfo);

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

		dia.dispose();
	} //userJoin end
	
//	// user 정보 Server에 전달
//	private void userSendServer(Map<String, UserInfo> userInfo) {
//		// TODO Auto-generated method stub
//		OutputStream os = null;
//		ObjectOutputStream oos =null;
//		try {	
//			
//				os = clientSock.getOutputStream();
//				oos = new ObjectOutputStream(os);					
//				
//				oos.writeObject(userInfo);
//
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}finally {
//          
//			try {
//				if(oos!=null)oos.close();
//				if(os!=null)os.close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}	
//	}//userSendServer end

}