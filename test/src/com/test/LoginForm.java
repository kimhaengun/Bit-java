package com.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

class UserInfo{
	private String userId;
	private String userPassword;
	
	public UserInfo(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}


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
	public LoginForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
//				if(!change)dispose();
				dispose();
			}
		});
		setTitle("로그인");
		setLayout(new BorderLayout());
		
		init();
		setting();
		batch();
		
		joinL.addMouseListener(this);
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
		
		//<회원가입 창>
		
	}
	
	public void setting() {
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
		System.out.println("회원가입 클릭 됨");
		dia = new Dialog(this);
		joinP = new Panel();
		joinP1  = new Panel();
		joinP2 = new Panel();
		joinIdL = new Label("ID   :");
		joinIdTf = new TextField(30);
		
		joinPwL = new Label("PW :");
		joinPwTf = new TextField(30);
		joinBtn = new JButton("회원가입");		
		
		dia.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
//				if(!change)dispose();
				dia.dispose();
			}
		});
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
		
	}



}
