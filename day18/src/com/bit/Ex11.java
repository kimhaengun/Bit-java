package com.bit;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Ex11 extends Frame implements TextListener{

	public Ex11() {
		
		Panel p = new Panel();
		TextField tf = new TextField(10);
		tf.addTextListener(this);
		p.add(tf);
		
		add(p);
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex11 me = new Ex11();
	}
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		String msg = ((TextField)e.getSource()).getText();
		System.out.println(msg); //source 는 이벤트 객체  = 이벤트가 일어난거
	}
}
