package com.step02;
import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		ServerSocket serve = null;
		Socket sock = null;
		InputStream is = null;
		OutputStream os = null;
		//문자열 처리
		InputStreamReader isr = null; 
		OutputStreamWriter osw = null;
		//라인 단위 Buffered
		BufferedReader br = null;
		//개행
		PrintWriter pw = null;
		
		try {
			serve = new ServerSocket(8080);
			sock = serve.accept();
			//읽어오고 쓰기
			is = sock.getInputStream();
			os = sock.getOutputStream();
			//문자열로 읽어오기
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			//버퍼 달기
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);
			
			String msg = null;
			while((msg=br.readLine())!=null) {
				//읽어온 내용 println으로 읽기
				pw.println("re:"+msg);
				//buffer가 꽉 찰때까지 밀어내지 않기 떄문에 밀어내 줘야함..
				//메시지 보낼 시 flush 필수 !!! = buffer 밀어내기
				pw.flush();
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
				if(serve!=null)serve.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
	}
}
