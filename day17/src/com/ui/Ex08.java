package com.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

public class Ex08 extends Frame{

	public Ex08() {
		
		setLayout(new BorderLayout());
		Panel p = new Panel();
		TextArea ta = new TextArea("값을 입력해 주세요",3,60,TextArea.SCROLLBARS_NONE);
		p.add(ta);
		
		
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(4,4,10,10));
		Button btn1 = new Button("7");
		Button btn2 = new Button("8");
		Button btn3 = new Button("9");
		Button btn4 = new Button("*");
		Button btn5 = new Button("4");
		Button btn6 = new Button("5");
		Button btn7 = new Button("6");
		Button btn8 = new Button("/");
		Button btn9 = new Button("1");
		Button btn10 = new Button("2");
		Button btn11 = new Button("3");
		Button btn12 = new Button("-");
		Button btn13 = new Button("+");
		Button btn14 = new Button("0");
		Button btn15 = new Button(".");
		Button btn16 = new Button("=");
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		p2.add(btn6);
		p2.add(btn7);
		p2.add(btn8);
		p2.add(btn9);
		p2.add(btn10);
		p2.add(btn11);
		p2.add(btn12);
		p2.add(btn13);
		p2.add(btn14);
		p2.add(btn15);
		p2.add(btn16);
		add(p,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		
		setLocation(100, 100);
		setSize(500, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		Ex08 me = new Ex08();
	}

}
