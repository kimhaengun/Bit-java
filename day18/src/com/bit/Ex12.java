package com.bit;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ex12 extends Frame implements ItemListener{
	
	public Ex12() {
		// TODO Auto-generated constructor stub
		Panel p = new Panel();
		Choice ch = new Choice();
		ch.addItem("1");
		ch.addItem("2");
		ch.addItem("3");
		ch.addItemListener(this);
		
		p.add(ch);
		add(p);
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex12 me = new Ex12();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Choice cho = (Choice)e.getSource();
		System.out.println(cho.getSelectedItem());
		
	}
}
