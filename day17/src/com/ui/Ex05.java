package com.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class Ex05 extends Frame{
	public Ex05() {
		
		setLayout(null);
		
		Button btn1 = new Button();
		btn1.setSize(100, 100);
		btn1.setLocation(50, 50);
		btn1.setLabel("btn1");
		
		add(btn1);
		
		
		
		setLocation(200, 200);
		setSize(400,200);
		setResizable(false); //창 못늘리게
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex05();

	}

}
