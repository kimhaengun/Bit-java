package com.bit;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JLabel;

public class Ex03 extends Frame {
	
	public Ex03() {
		
		Panel p = new Panel();
		
		Label lb = new Label("����");
		
		Font f = new Font("Arial, Serif, Monospaced",Font.BOLD,20);
		lb.setFont(f);
		lb.setForeground(new Color(153,51,255));
		
		TextField tf = new TextField(20);
		tf.setFont(f); //���̴� font�� ����
		tf.setEditable(false);
		

		Button btn1 = new Button("��ư");
		Dimension di = new Dimension();
		di.height = 50;
		di.width = 50;
		btn1.setPreferredSize(di);
		btn1.setFont(f);
		
		p.setBackground(new Color(0,0,2));
		p.add(lb);
		p.add(tf);
		p.add(btn1);

		add(p);
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex03();
	}
}
