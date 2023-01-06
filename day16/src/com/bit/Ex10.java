package com.bit;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class Ex10 {
/*
 * 상대경로, 절대경로
 * 
 */
	public static void main(String[] args) {
		// 상대 경로
		File file = new File("Lec01.txt");
//		File file = new File(".\\Lec01.txt");
		
		// 절대 경로
//		File file = new File("E:\\java\\day16\\Lec01.txt");
//		File file = new File("E:\\java\\day16\\test01");
//		File file = new File("E:\\java\\day16\\src\\com\\bit");
		
		System.out.println("유무 = "+file.exists());
		if (file.exists()) {
			System.out.println("dir = "+file.isDirectory());
			System.out.println("file = "+file.isFile());
			System.out.println("경로 = "+file.getPath());
			System.out.println("위치 = "+file.getParent());
			System.out.println("이름 = "+file.getName());
			System.out.println("절대 경로1 = "+file.getAbsolutePath());
			try {
				System.out.println("절대 경로2(찐) = "+file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("r : "+file.canRead());
			System.out.println("w : "+file.canWrite());
			System.out.println("x : "+file.canExecute());
			System.out.println("size : "+file.length()+"byte");
			System.out.println("수정 : "+new Date(file.lastModified()));
			
			//디렉토리 안 파일 보기
			String[] arr = file.list();
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
	}

}
