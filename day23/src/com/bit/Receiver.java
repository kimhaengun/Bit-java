package com.bit;
import java.io.IOException;
import java.net.*;
public class Receiver {

	public static void main(String[] args) {
		DatagramSocket sock = null;
		DatagramPacket packet = null;
		byte[] buf = new byte[4];
		try {
			sock = new DatagramSocket(8080);
			
			packet = new DatagramPacket(buf, buf.length);
			sock.receive(packet);
			buf = packet.getData();
			System.out.println(new String(buf));

			packet = new DatagramPacket(buf, buf.length);
			sock.receive(packet);
			buf = packet.getData();
			System.out.println(new String(buf));
			
			if(sock!=null) {
				sock.close();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
