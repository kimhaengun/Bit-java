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



public class LoginForm extends Frame implements MouseListener,ActionListener{
	
	//로그인
	Panel northP, centerP, idP, pwP, eastP, southP;
	JLabel northL, joinL;
	Label idL, pwL;
	TextField idTf, pwTf;
	Button loginBtn;
	Dimension di;
	//회원가입
	Dialog dia;
	Panel joinP, joinP1, joinP2;
	Label joinIdL, joinPwL;
	JButton joinBtn;
	TextField joinIdTf,joinPwTf;
	Socket clientSock;
//	ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
	OutputStream os = null;
	ObjectOutputStream oos =null;
	
	public LoginForm(Socket clientSock) {
		this.clientSock = clientSock;
		System.out.println("Log : "+this.clientSock);
		new LoginForm();
	}
	
	
	public LoginForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
//				if(!change)dispose();
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
		idTf = new TextField(30);
		pwP = new Panel();
		pwL = new Label("PW :");
		pwTf = new TextField(30);
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
		idP.add(idTf);
		pwP.add(pwL);
		pwP.add(pwTf);	
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
			String userJoinId = joinIdTf.getText();
			String userJoinPw = joinPwTf.getText();
//			userList.add(userInfo);
			UserInfo userInfo = new UserInfo(userJoinId, userJoinPw);		
			Map<String, UserInfo> userJoinInfo = new HashMap<String, UserInfo>();
			userJoinInfo.put("join", userInfo);
			
			System.out.println(userJoinInfo.get("join").getUserId());
			System.out.println(userJoinInfo.get("join").getUserPassword());

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
			
//			File f = new File("userList.bin");
//			OutputStream os = null;
//			ObjectOutputStream oos = null;
//			try {
//				if(!f.exists()) {
//					f.createNewFile();
//				}
//				os = new FileOutputStream(f);
//				oos = new ObjectOutputStream(os);
//				
//				oos.writeObject(userList);
//				
//				System.out.println("회원가입 완료");
//				dia.dispose();
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}finally {
//				try {
//					if(oos!=null)oos.close();
//					if(oos!=null)os.close();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
		} //회원가입 action end
		
		if(e.getActionCommand().contentEquals("LOGIN")) { //로그인 Action
			System.out.println("로그인~~");
			dispose();
			new MainForm();
		} //로그인 Action end
	}

	private void joinUser(Map<String, UserInfo> userJoinInfo) {
		// TODO Auto-generated method stub

	}



}
