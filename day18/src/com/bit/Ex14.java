package com.bit;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex14 extends Frame implements MouseListener, ContainerListener{

	Panel p = new Panel();
	Button btn = new Button("�߰�");
	
	public Ex14() {
		p.addContainerListener(this);
		btn.addMouseListener(this);
		p.add(btn);
		add(p);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex14 me = new Ex14();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Label lb = new Label("�ȳ�?");
		lb.addMouseListener(this);
		p.add(lb);
		validate(); //�˻�
//		revalidate(); //��˻�
//		repaint(); //�ٽ� �׸���
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource()!=btn ) {
			Label la = (Label)e.getSource();
			la.setVisible(false);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
//////////////////////////////////////////////////////////////////////////////////
	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�߰���");
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub
		
	}
}
