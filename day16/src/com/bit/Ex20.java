package com.bit;

import java.io.*;
import java.util.*;

public class Ex20 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("E:\\java\\day16\\src\\com\\bit\\Ex01.java");
//		InputStream is =new FileInputStream(f); 
				//System.in;
		Scanner sc = new Scanner(f);
		
		while(sc.hasNext()) {
			String msg = sc.nextLine();
			System.out.println(msg);			
		}

		
	}

}
