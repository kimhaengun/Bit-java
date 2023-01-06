package com.bit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;

public class Ex01 extends Frame{

	public Ex01() {
		LayoutManager lm = new BorderLayout();
		setLayout(lm);
		
		Panel p = new Panel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		String[][] msg = {{"7","8","9","+"},
				{"4","5","6","/"},
				{"1","2","3","="},
				{"0","."}};
		for (int i = 0; i < 4; i++) {
			String[] col = msg[i];
			for (int j = 0; j < col.length; j++) {
				gbc.gridx = j;
				gbc.gridy = i;
				if(i==2&&j==3) {
					gbc.gridheight=2;
				}else {
					gbc.gridheight=1;
				}
				if(i==3&&j==0) {
					gbc.gridwidth=2;
				}else {
					gbc.gridwidth=1;
				}
				if(i==3&&j==1) {
					gbc.gridx = 2;
				}else {
					
				}
				p.add(new Button(col[j]),gbc);
				
			}
			
		}
		

		add(new TextField(),BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		setLocation(100, 100);
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex01();
	}
}
