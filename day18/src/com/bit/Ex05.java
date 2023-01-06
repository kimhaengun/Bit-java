package com.bit;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Ex05 extends Frame{
	public Ex05() {
		
		MenuBar mb = new MenuBar();
		Menu m1 = new Menu("메뉴1");
		m1.add("1-1");
		m1.add("1-2");
		m1.add("1-3");
		mb.add(m1);
		
		Menu m2 = new Menu("메뉴2");
		
		MenuItem mi = new MenuItem("2-1");
		
		Menu mi2 = new Menu("2-2");
		MenuItem mi2_1 = new MenuItem("2-2-1");
		
		
		mi2.add(mi2_1);
		m2.add(mi);
		m2.add(mi2);
		mb.add(m2);
		
		Menu m3 = new Menu("메뉴3");
		mb.add(m3);
		setMenuBar(mb);
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex05();
	}
}
