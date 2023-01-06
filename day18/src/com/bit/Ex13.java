package com.bit;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Ex13 extends Frame implements FocusListener, TextListener{

	public Ex13() {
		Panel p = new Panel();
		TextField[] arr = new TextField[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=new TextField(10);
			arr[i].addFocusListener(this);
			
			p.add(arr[i]);
		}
		arr[2].requestFocusInWindow();
		add(p);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex13 me = new Ex13();
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText()+"포커스 얻고");
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText()+"포커스 잃고");
	}
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		TextField tf = (TextField)e.getSource();
		if(tf.getText().length()==4) {
			tf.nextFocus();
		}
	}

}
