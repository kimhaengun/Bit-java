package com.bit;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex10 extends Frame implements KeyListener{
	Label lb;
	TextField tf;
	public Ex10() {
		Panel p = new Panel();
		
		tf = new TextField(20);
		tf.addKeyListener(this);
		p.add(tf);
		Button cho = new Button();
		lb = new Label("★");
		this.addKeyListener(this);
		p.add(lb);
//		p.add(cho);
		add(p);
		
		setBounds(600, 100, 400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex10 me=new Ex10();
		while(true) {
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch = e.getKeyChar();
		int su = e.getKeyCode();
		System.out.println(ch+"눌렸고"+su);
		System.out.println(tf.getText());
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch = e.getKeyChar();
		int su = e.getKeyCode();
		System.out.println(ch+"누르는 중이고"+su);
		System.out.println(tf.getText());
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//지금까지 입력한 값 가져오기
		char ch = e.getKeyChar();
		int su = e.getKeyCode();
		System.out.println(ch+"올라옴"+su);
		System.out.println("!:"+tf.getText());
		
		
		
		
		int x =lb.getX();
		int y =lb.getY();
		if(su==39) {
			lb.setLocation(x+10, y);
		}else if(su==37) {
			lb.setLocation(x-10, y);
		}else if(su==38) {
			lb.setLocation(x, y-10);
		}else if(su==40) {
			lb.setLocation(x, y+10);
		}
		
	}
}
