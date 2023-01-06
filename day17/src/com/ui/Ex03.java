package com.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Ex03 extends Frame{
	static CardLayout cl;
	public Ex03() {
		/*
		 *  FlowLayout = 무조건 가운대 정렬
		 *             = 넓이 초과시 밑으로 내려감
		 */
//		setLayout(new FlowLayout());
//		setLayout(new GridLayout(3,2)); //(세로, 가로)
//		setLayout(new BorderLayout());
		
		cl = new CardLayout();
		setLayout(cl);
		
		Button btn1 = new Button();
		btn1.setLabel("button1");
		Button btn2 = new Button();
		btn2.setLabel("button2");
		Button btn3 = new Button();
		btn3.setLabel("button3");
		Button btn4 = new Button();
		btn4.setLabel("button4");
		Button btn5 = new Button();
		btn5.setLabel("button5");

		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		setSize(300,300);
		setLocation(700, 300);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Ex03 me = new Ex03();
		me.setVisible(true);
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			cl.next(me);			
		}

	}
}
