package com.bit;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex08 extends Frame implements MouseListener{
	
	public Ex08() {
		
		Panel p = new Panel();
		Button btn = new Button("�Ǿ�");
		
		btn.addMouseListener(this);
		
		p.add(btn);
		add(p);
		setBounds(600, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex08();
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		System.out.println("Ŭ��");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub.
		// ���� = �̺�Ʈ ��ü
		int x = e.getX();
		int y = e.getY();
		System.out.println("���� x:"+x+" y:"+y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("[���Ⱦ��µ�]�ö��");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("[������Ʈ ����] �ö��");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("[������Ʈ����] ��������");
	}
}
