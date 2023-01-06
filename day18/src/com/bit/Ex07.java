package com.bit;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

public class Ex07 extends Frame implements WindowListener{
	
	public Ex07() {
		
		addWindowListener(this);
		
		
		setBounds(100, 100, 100, 100);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Ex07 me = new Ex07();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창열림");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("닫기 버튼");
		dispose();
//		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("call disposed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("최소화 버튼");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("안최소화");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("활성화");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("비활성화");
	}
}
