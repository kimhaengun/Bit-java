package com.step04;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/*
 * 클라이언트에서 메시지 보내고 서버로부터 읽기
 */
public class Client extends Frame implements ActionListener{
	static TextArea ta = new TextArea();
	static TextField tf = new TextField();
	static PrintWriter pw;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = tf.getText();
		pw.println(msg);
		pw.flush();
		tf.setText("");
		tf.setText("");
	}
	public Client() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		tf.addActionListener(this);
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		Client client = new Client();
//		String url="192.168.240.210";
		String url="127.0.0.1";
		int port = 8080;
		Socket sock = null;
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		


		Scanner sc = new Scanner(System.in);
		
		try {
			sock = new Socket(url,port); //접속 완료
			is = sock.getInputStream();
			os = sock.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);
			String msg = null;
			while(true) {
				System.out.print("메시지 >");
				
				//buffer가 꽉 찰때까지 밀어내지 않기 떄문에 밀어내 줘야함..
				//메시지 보낼 시 flush 필수 !!! = buffer 밀어내기
				msg = br.readLine();
				if(msg.equals("exit"))break;
				System.out.println(msg);
				//읽어온 메시지 textArea에 뿌리기
				ta.append(msg+"\n");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pw!=null)pw.close();
				if(br!=null)br.close();
				if(osw!=null)osw.close();
				if(isr!=null)isr.close();
				if(os!=null)os.close();
				if(is!=null)is.close();
				if(sock!=null)sock.close();				
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}


}
