package com.bit;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.xml.crypto.Data;

public class Ex17 extends Frame implements ActionListener{
	TextArea ta;
	static Ex17 me;
	public Ex17() {
		WindowAdapter eve = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		};
		Panel p = new Panel();
		
		MenuBar mb = new MenuBar();
		Menu m1 = new Menu("파일");
		MenuItem mi1 = new MenuItem("새로만들기");
		mi1.addActionListener(this);
		MenuItem mi2 = new MenuItem("열기");
		mi2.addActionListener(this);

		MenuItem mi3 = new MenuItem("저장");
		mi3.addActionListener(this);
		
		MenuItem mi4 = new MenuItem("종료");
		mi4.addActionListener(this);
		Menu m2 = new Menu("도움말");
		m2.addActionListener(this);
		MenuItem mi5 = new MenuItem("정보");
		mi5.addActionListener(this);
		
		
		ta = new TextArea("",21,35,TextArea.SCROLLBARS_BOTH);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);
		m2.add(mi5);
		mb.add(m1);
		mb.add(m2);
		
		setMenuBar(mb);
		p.add(ta);
		add(p);
		addWindowListener(eve);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		me = new Ex17();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("새로만들기")) {
			me = new Ex17();
		}
		if(e.getActionCommand().equals("열기")) {
			System.out.println("열기 클릭했네요");
			FileDialog fda = new FileDialog(this,"팝업창",FileDialog.LOAD);
			fda.setBounds(200, 200, 200, 200);
			fda.setVisible(true);
			String filename = fda.getFile();
			String parent = fda.getDirectory();
			String name = fda.getName();
			String title = fda.getTitle();
			System.out.println("파일 다이얼로그 호출");
			System.out.println(filename);
			System.out.println(parent);
			System.out.println(name);
			System.out.println(title);
			File f = new File(parent+filename);
			System.out.println(f);
			InputStream is = null;
			int su = -1;
			String msg = "";
			try {
				if(f.exists()) {
					System.out.println("야바아");
					is = new FileInputStream(f);

					while(true){
						su=is.read();
						if(su==-1) {
							break;
						}
						msg += (char)su;
					}
					ta.setText(msg);
				}
			} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("저장")) {
			System.out.println("저장 클릭");
			System.out.println(ta.getText().length());
			if(ta.getText().length()>0) {
				FileDialog fda = new FileDialog(this,"팝업창",FileDialog.SAVE);
				fda.setBounds(200, 200, 200, 200);
				fda.setVisible(true);
				String filename = fda.getFile();
				String parent = fda.getDirectory();
				String name = fda.getName();
				String title = fda.getTitle();
				System.out.println("파일 다이얼로그 호출");
				System.out.println(filename);
				System.out.println(parent);
				System.out.println(name);
				System.out.println(title);
				
				File f = new File(parent+filename);
				OutputStream os = null;
				
				try {
					if(!f.exists()) {
						f.createNewFile();
					}
					os = new FileOutputStream(f);
					String msg = ta.getText();
					byte[] arr = msg.getBytes();
					os.write(arr);
					if(os!=null)os.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
			
		}else if(e.getActionCommand().equals("종료")) {
			me.dispose();
		}else if(e.getActionCommand().equals("정보")) {
			Dialog dia = new Dialog(this);
			WindowAdapter eve2 = new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					dia.dispose();
				}
			};
			Date today = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:ss");
			String result = df.format(today);
			
			Panel p = new Panel();
			Label tf = new Label();
			Label tf2 = new Label();
			
			
			tf.setText("내가 만듬");
			tf2.setText(result);
			p.add(tf);
			p.add(tf2);
			dia.add(p);
			dia.setBounds(200, 200, 200, 200);
			dia.setVisible(true);
			
			dia.addWindowListener(eve2);
		}
	}
}
