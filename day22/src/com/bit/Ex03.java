package com.bit;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex03 {

	public static void main(String[] args) {
		// 프로토콜://도메인:포트번호/
		// 프로토콜://도메인:포트번호/경로/../경로?queryString#앵커(reference)
		URL url = null;
		String msg ="https://n.news.naver.com/article/119/0002672672?cds=news_media_pc&type=editn";
		try {
			url = new URL(msg);
			System.out.println("protocol: "+url.getProtocol());
			System.out.println("domain: "+url.getHost());
			System.out.println("port: "+url.getPort());
			System.out.println("default port: "+url.getDefaultPort());
			System.out.println("path: "+url.getPath());
			System.out.println("query: "+url.getQuery()); // Client --> Server로 요청하는 정보
			System.out.println("ref: "+url.getRef());
			System.out.println("file: "+url.getFile());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
