package com.bit;

import java.io.IOException;
import java.net.*;

public class Sender {

	public static void main(String[] args) {
		DatagramSocket sock = null;
		DatagramPacket packet = null;
		InetAddress addr =null;
		byte[] arr = {127,0,0,1};
		try {
			addr = InetAddress.getByAddress(arr);
			sock = new DatagramSocket();
			
			packet = new DatagramPacket("abcd".getBytes(), 4,addr,8080);
			sock.send(packet);
			packet = new DatagramPacket("cdrg".getBytes(), 4,addr,8080);
			sock.send(packet);
			
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
