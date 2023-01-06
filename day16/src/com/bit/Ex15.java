package com.bit;

import java.io.*;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Lec01.txt");
		try {
			File file2 = file.createTempFile("abcdfg", ".txt");
			System.out.println(file2.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
