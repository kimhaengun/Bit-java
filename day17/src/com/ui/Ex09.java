package com.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;

public class Ex09 extends Frame{
	
	public Ex09() {
		
		setLayout(new BorderLayout());
		Panel p = new Panel();
		TextArea ta = new TextArea("값을 입력해 주세요",3,60,TextArea.SCROLLBARS_NONE);
		p.add(ta);
		
		
		Panel p2 = new Panel();
		LayoutManager lm = new GridBagLayout();
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		p2.setLayout(lm);
		gbc.fill = GridBagConstraints.BOTH;
		Button btn1 = new Button("7");
		Button btn2 = new Button("8");
		Button btn3 = new Button("9");
		Button btn4 = new Button("+");
		
		Button btn5 = new Button("4");
		Button btn6 = new Button("5");
		Button btn7 = new Button("6");
		Button btn8 = new Button("-");
		
		Button btn9 = new Button("1");
		Button btn10 = new Button("2");
		Button btn11 = new Button("3");
		Button btn12 = new Button("=");
		
		Button btn13 = new Button("0");
		Button btn14 = new Button(".");
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.insets = new Insets(5, 5, 5, 5);
		p2.add(btn1,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn2,gbc);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn3,gbc);
		
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn4,gbc);

		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn5,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn6,gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn7,gbc);
		
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn8,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn9,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn10,gbc);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn11,gbc);
		
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.gridheight=2;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn12,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn13,gbc);
		
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1;
		gbc.weighty=1;
		p2.add(btn14,gbc);

		add(p,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		
		setLocation(100, 100);
		setSize(500, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex09 ex09 = new Ex09();
	}
}
