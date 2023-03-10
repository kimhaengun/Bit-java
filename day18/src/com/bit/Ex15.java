package com.bit;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex15 extends Frame implements ActionListener{

	public Ex15() {
		// TODO Auto-generated constructor stub
		MenuBar mb = new MenuBar();
		Menu m = new Menu("메뉴1");
		MenuItem mi = new MenuItem("1-1");
		Menu m2 = new Menu("메뉴2");
		m.add(mi);
		m.add("메뉴3");
		mb.add(m);
		mb.add(m2);
		setMenuBar(mb);

		Panel p = new Panel();
		Label lb = new Label("label");
		Button btn1 = new Button("버튼");
		TextField tf = new TextField(10);
		TextArea ta = new TextArea();
		Choice cho = new Choice();
		cho.addItem("item");
		cho.addItem("item2");
		cho.addItem("item3");
		
		List list = new List();
		list.addItem("list1");
		list.addItem("list2");
		list.addItem("list3");
		
		Checkbox cb1 = new Checkbox("chk1");
		Checkbox cb2 = new Checkbox("chk2");
		Checkbox cb3 = new Checkbox("chk3");
		
	
		p.add(lb);
		p.add(btn1);
		p.add(tf);
		p.add(ta);
		p.add(cho);
		p.add(list);
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		
		m.addActionListener(this);
		
		add(p);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex15 me = new Ex15();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action");
	}
}
