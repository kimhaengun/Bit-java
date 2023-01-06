package com.bit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Ex14 extends Frame implements ActionListener,Runnable{
	static Ex14 me;
	static Thread thr;
	Label menuLabel;
	Label scoreLabel;
	String[] arr = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
	Button[] lb = new Button[16];
	Color nomalColor = new Color(240,240,240); //기본
	Color selectColor = new Color(139,0,255); //
	int count=0;
	int countM = 10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				System.out.println("스레드 동작함");
				for (int i = 0; i < 10; i++) {
					int r = ((int)(Math.random()*16));
					lb[r].setBackground(selectColor);
					Thread.sleep(1000);	
					lb[r].setBackground(nomalColor);
					countM--;
					menuLabel.setText(countM+"count");
					if(countM==0) {
						thr.stop();
					}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public Ex14() {
		// TODO Auto-generated constructor stub
		WindowAdapter eve = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		};
		setLayout(new BorderLayout());
		setTitle("두더지 잡기");
		
		//north
		Panel northPanel = new Panel();
		
		menuLabel = new Label();
		menuLabel.setText(countM+"count");
		northPanel.add(menuLabel);
		
		//center
		Panel centerPanel = new Panel();
		
		centerPanel.setLayout(new GridLayout(4, 4,5,5));
		for (int i = 0; i < arr.length; i++) {
			lb[i] = new Button();
			lb[i].addActionListener(this);
			centerPanel.add(lb[i]);
			
		}
		
		//east
		Panel eastPanel = new Panel();
		
		Button startBtn = new Button("start");
		Dimension di = new Dimension();
		di.height=100;
		di.width=100;
		startBtn.setPreferredSize(di);
		startBtn.addActionListener(this);
		Button endBtn = new Button("end");
		endBtn.setPreferredSize(di);
		endBtn.addActionListener(this);
		eastPanel.add(startBtn);
		eastPanel.add(endBtn);

		
		//south
		Panel southPanel = new Panel();
		scoreLabel = new Label();
		scoreLabel.setText("Score"+count);
		southPanel.add(scoreLabel);
		
		add(northPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(eastPanel,BorderLayout.EAST);
		add(southPanel,BorderLayout.SOUTH);
		addWindowListener(eve);
		setBounds(100, 100, 800, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		me = new Ex14();
		thr = new Thread(me);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(((Button)e.getSource()).getName());
//		if(e.getActionCommand().equals("start")) {
//			
//			thr.start();
//		}
		if(e.getActionCommand().equals("end")) {
			System.out.println("종료 클릭됨");
			thr.stop();
		}
		if(((Button)e.getSource()).getBackground().getRed()==139) {
			System.out.println("잡힘");
			count++;
			scoreLabel.setText("Score:"+count);
			
		}
	}



}
