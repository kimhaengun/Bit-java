package com.ui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ex07 extends Frame{
	
	public Ex07() {
		Panel p = new Panel();
		
		Button btn1 = new Button("hello");
		btn1.setEnabled(false);
		p.add(btn1);
		
		JButton btn2 = new JButton("한글");
		btn2.setText("");
		byte[] arr = new byte[5814];
		File f = new File("target.jpg");
		InputStream is;
		try {
			is = new FileInputStream(f);
			for (int i = 0; i < arr.length; i++) {
				arr[i]=(byte)is.read();
			}
			if(is!=null)is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Icon defaultIcon = new ImageIcon(arr);
		btn2.setIcon(defaultIcon);
		p.add(btn2);
		/////////////////////////////////////////
		TextField tf = new TextField(10);
		tf.setText("ab");
		tf.setEchoChar('#'); //비밀번호 등록시 유용 = 입력 받은 값 지정 표시로 바꿔줌
		p.add(tf);
		/////////////////////////////////////////
		TextArea ta = new TextArea("default",5,10,TextArea.SCROLLBARS_BOTH);
		p.add(ta);
		////////////////////////////////////////
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("item1",false,cbg);
		Checkbox cb2 = new Checkbox("item2",false,cbg);
		Checkbox cb3 = new Checkbox("item3",false,cbg);

		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		////////////////////////////////////////
		// Select Box
		Choice cho = new Choice();
		cho.addItem("item1");
		cho.addItem("item2");
		cho.addItem("item3");
		cho.addItem("item4");
		cho.select(2);
		p.add(cho);
		////////////////////////////////////////
		// List
		List list = new List(5,true); //true = 다중 선택 가능
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.add("item5");
		list.add("item6");
		list.select(2);
		p.add(list);
		////////////////////////////////////////
		// Label
		Label lb = new Label("<OooO>");
		p.add(lb);
		
		JLabel jlb = new JLabel();
		jlb.setIcon(defaultIcon);
		p.add(jlb);
		
		add(p);
		setLocation(100, 100);
		setSize(500, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex07();
	}
}
