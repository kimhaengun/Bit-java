package com.bit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ex01 extends Frame implements ActionListener,Runnable{
	Label nla ,sla;
	JButton[] btns;
	Button startBtn;
	Panel pc;
	int cnt;
	public Ex01() {
		setLayout(new BorderLayout());
		Panel pn = new Panel();
		nla = new Label("60s");
		pn.add(nla);
		
		Panel ps = new Panel();
		sla = new Label("Num:0");
		ps.add(sla);
		btns = new JButton[4*4];
		pc = new Panel(new GridLayout(4,4));
		
		for (int i = 0; i < btns.length; i++) {
			btns[i]= new JButton();
			ImageIcon defaultIcon = null;
			if(i%4==0 || i%4==2) {
				defaultIcon = new ImageIcon("target.jpg");
			}else {
				defaultIcon = new ImageIcon("target2.jpg");
			}
			
			if(i%4==0||i%4==2) {
				btns[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cnt++;
						sla.setText("Nym"+cnt);
					}
				});
			}else {
				btns[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cnt--;
						sla.setText("Nym"+cnt);
					}
				});	
			}

			btns[i].setIcon(defaultIcon);
			
		}
		for (int i = 0; i < btns.length; i++) {
			btns[i].setEnabled(false);
		}

		mix();

		
		Panel pe = new Panel(new GridLayout(4,1));
		startBtn = new Button("start");
		Button endBtn = new Button("end");
		startBtn.addActionListener(this);
		endBtn.addActionListener(this);
		pe.add(new Label());
		pe.add(startBtn);
		pe.add(new Label());
		pe.add(endBtn);
		pe.add(new Label());
		
		add(pn,BorderLayout.NORTH);
		add(ps,BorderLayout.SOUTH);
		add(pc,BorderLayout.CENTER);
		add(pe,BorderLayout.EAST);
		
		
		
		setBounds(100, 100, 450, 750);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex01 me = new Ex01();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		if(btn.getLabel().equals("start")) {
			System.out.println("start");
			Thread thr = new Thread(this);
			thr.start();
		}else if(btn.getLabel().equals("end")) {
			dispose();
		}
		
		
	}
	public void editBtns(boolean boo) {
		for (int i = 0; i < btns.length; i++) {
			btns[i].setEnabled(boo);
		}
	}
	
	public void mix() {
		Random random = new Random();
		for (int i = 0; i < 16; i++) {
			int ran1 = random.nextInt(16);
			int ran2 = random.nextInt(16);
			JButton temp = btns[ran1];
			btns[ran1] = btns[ran2];
			btns[ran2] = temp;			
		}
		for (int i = 0; i < btns.length; i++) {
			pc.add(btns[i]);
		}
//		repaint();
//		validate();
		revalidate();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int time = 60;
		startBtn.setEnabled(false);
		nla.setText(time+"s");
		editBtns(true);
		Thread thr = new Thread() {
			@Override
			public void run() {
				while (!startBtn.isEnabled()) {
					mix();
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};
		thr.start();
		while(time>=0) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			time--;
			
		}
		thr.stop();
		editBtns(false);
		
	}
}
