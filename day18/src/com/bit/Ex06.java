package com.bit;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;

public class Ex06 {
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame();
		f.setTitle("����~~~~~");
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
		
//		Dialog dia = new Dialog(f);
//		dia.setBounds(200, 200, 200, 200);
//		dia.setVisible(true);

		FileDialog dia2 = new FileDialog(f,"�˾�â",FileDialog.LOAD);
		dia2.setTitle("����");
		dia2.setBounds(200, 200, 200, 200);
		dia2.setVisible(true);
		String filename = dia2.getFile();
		String parent = dia2.getDirectory();
		String name = dia2.getName();
		String title = dia2.getTitle();
		System.out.println("���� ���̾�α� ȣ��");
		System.out.println(filename);
		System.out.println(parent);
		System.out.println(name);
		System.out.println(title);
		
		Thread.sleep(3000);
		f.dispose(); //dia�� f�� ���ӵǾ� �ֱ� ������ f�� ������ dia�� ����
		
	}
}
