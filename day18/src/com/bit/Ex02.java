package com.bit;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class Ex02 extends Frame{
	public static void main(String[] args) {
		Ex02 me = new Ex02();
		me.setLocation(100, 100);
		Dimension di = new Dimension();
		di.width=700;
		di.height=400;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di2 = tk.getScreenSize();
		System.out.println(di);
		int w=(di2.width/2)-(di.width/2) , h=(di2.height/2)-(di.height/2);
//		me.setBounds(w, h, di.width, di.height);
		me.setLocation(w, h);
		me.setSize(di);
		me.setVisible(true);
	}
}
