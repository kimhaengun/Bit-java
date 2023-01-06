package com.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;

public class Ex06 extends Frame{

	public Ex06() {
		setLayout(new BorderLayout());
		Panel p = new Panel();
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(2,3));
		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		btn1.setLabel("한글");
//		p.setLayout(new GridLayout());
		p.add(btn1);
		btn2.setLabel("한글2");
//		p.setLayout(new GridLayout());
		p2.add(btn2);
		
		
		
		add(p,BorderLayout.CENTER);
		add(p2,BorderLayout.WEST);
		
		setLocation(100, 100);
		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex06();
	}
}
