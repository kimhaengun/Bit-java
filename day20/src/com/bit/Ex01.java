package com.bit;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex01 extends Frame implements ActionListener,TextListener{
	
	TextArea ta = new TextArea();
	boolean change;
	public Ex01() {
		setTitle("제목없음");
		MenuBar mb = new MenuBar();
		Menu mn1 = new Menu("File");
		MenuItem mi1 = new MenuItem("New");
		MenuItem mi2 = new MenuItem("Open");
		MenuItem mi3 = new MenuItem("Save");
		MenuItem mi4 = new MenuItem("Exit");
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		
		mn1.add(mi1);
		mn1.addSeparator();
		mn1.add(mi2);
		mn1.add(mi3);
		mn1.addSeparator();
		mn1.add(mi4);
		mb.add(mn1);
		Menu mn2 = new Menu("Help");
		MenuItem mi5 = new MenuItem("About");
//		mi5.addActionListener(this);
		mn2.add(mi5);
		mb.add(mn1);
		mb.add(mn2);
		
		
		setMenuBar(mb);
		ta.addTextListener(this);
		add(ta);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
//				if(!change)dispose();
				dispose();
			}
		});
		
		
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	Ex01 me = new Ex01();	
	System.out.println("main end");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("action");
		MenuItem mi = (MenuItem)e.getSource();
		if(mi.getLabel().equals("Exit")) {
			dispose();
		}else if(mi.getLabel().equals("About")) {
			
			Dialog dia = new Dialog(this,"About");
			dia.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					dia.dispose();
				}
			});
			
			
			dia.setLayout(new GridLayout(3,1));
			
			Panel p1 = new Panel();
			Panel p2 = new Panel();
			Panel p3 = new Panel();
			Label lb1 = new Label("Welcome");
			p1.add(lb1);
			lb1.setFont(new Font("", Font.BOLD, 26));
			p2.add(new Label("2023-01-02"));
			Button btn = new Button("Close");
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dia.dispose();
				}
			});
			Dimension di = new Dimension();
			di.height=30;
			di.width=50;
			btn.setPreferredSize(di);
			p3.add(btn);
			
			dia.add(p1);
			dia.add(p2);
			dia.add(p3);
			dia.setBounds(200,200,300,150);
			dia.setVisible(true);
		}
		if(mi.getLabel().equals("Save")) {
			FileDialog fd = new FileDialog(this,"save as...",FileDialog.SAVE);
			fd.setVisible(true);
			String fname = fd.getFile();
			String path = fd.getDirectory();
			File f = new File(path+fname);
			if(f.exists()) {
				//사용자 확인 후 덮어쓸것인지 확인
				return;
			}else {
				try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			OutputStream os = null;
			try {
				os = new FileOutputStream(f);
				
				os.write(ta.getText().getBytes());
				
				os.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			setTitle(fname);
		}
		if(mi.getLabel().equals("Open")) {
			FileDialog dia = new FileDialog(this, "open as...",FileDialog.LOAD);
			dia.setVisible(true);
			String fname = dia.getFile();
			String path = dia.getDirectory();
			File f = new File(path+fname);
			if(!f.exists()) {
				return;
			}
			//기존 데이터 읽어와서 배열로 담고 String으로 담기
			InputStream is = null;
//			List<Byte> list = new ArrayList<>();
			ByteArrayOutputStream baos = null;
			byte[] byt = null;
			try {
				is = new FileInputStream(f);
				baos = new ByteArrayOutputStream();
				int su = -1;
				while((su=is.read()) != -1 ) {
//					list.add((byte)su);
					baos.write(su);
				}
				byt = baos.toByteArray();
				
				if(baos!=null)baos.close();
				if(is!=null)is.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			byte[] byt = new byte[list.size()];
//			Object[] arr2 = list.toArray();
//			for (int i = 0; i < arr2.length; i++) {
//				byt[i]=(byte)arr2[i];
//			}
			String msg = new String(byt);
			ta.setText("");
			ta.setText(msg);
			setTitle(fname);
		}
		if(mi.getLabel().equals("New")) {
			ta.setText("");
			ta.setText("");
			setTitle("제목 없음");
		}
		
		
	}

	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
//		change = true;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("change as..");
	}
}
