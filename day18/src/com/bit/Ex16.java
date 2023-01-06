package com.bit;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
class WindL implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class Ex16 extends JFrame{

	public Ex16() {
//		WindowAdapter eve = new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				dispose();
//			}
//		};
//		addWindowListener(eve);
		Panel p = new Panel();
		add(p);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex16 me = new Ex16();
	}
}
