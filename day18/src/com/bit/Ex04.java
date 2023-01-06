package com.bit;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;




public class Ex04 extends Frame{
	
	static Ex04 me;
	class MyCanvas extends Canvas{
		Image img;
		public MyCanvas() {
			// TODO Auto-generated constructor stub
//			img = Toolkit.getDefaultToolkit().getImage("target.jpg");
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			img = tk.createImage("target.jpg");
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			char[] arr = "¾ß¾ß¾ß".toCharArray();
			g.drawChars(arr, 0, arr.length, 100, 100);
			g.drawLine(100, 100, 200, 200);
			g.setColor(Color.red);
			g.drawRect(200, 200, 100, 100);
			g.setColor(Color.magenta);
			g.fillOval(300, 300, 100, 100);

			System.out.println(img);
			g.drawImage(img, 100, 100, this);
		}
	}	
	

	
	public Ex04() {
		MyCanvas can = new MyCanvas();	
		can.setSize(300,300);
		add(can);
		
		
		setBounds(100,100,500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		me = new Ex04();
	}
}
