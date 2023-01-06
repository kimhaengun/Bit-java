package com.bit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex11 {
	public static void main(String[] args) {
//		System.out.println(args[0]);
//		System.out.println(args[1]);
		
		
		
//		File file = new File(args[1]);
//		String[] fileList = file.list();
//		
//		
//		for (int i = 0; i < fileList.length; i++) {
//			File fileInfo = new File(fileList[i]);
//			System.out.println("Info : "+fileInfo);
//			System.out.println("찐 경 : "+file.getAbsolutePath());
//			System.out.println("유무 : "+fileInfo.exists());
//			//Ex01.java, Ex02.java
//			
////			File fileIn = new File(file.getAbsolutePath());
//			System.out.println("날짜 : "+new Date(fileInfo.lastModified()));
//			if(fileInfo.exists()) {
//				System.out.println("??");
//				System.out.println(new Date(fileInfo.lastModified()));
//			}
//			
//			System.out.println("\t"+fileList[i]);
//			
//		}
		String path="E:\\java\\day16";
		if(args.length>0) {
			path = args[0];
		}
		
		File file = new File(path);
		if(file.exists()) {
			String[] arr = file.list();
			for (int i = 0; i < arr.length; i++) {
				file = new File(arr[i]);
				long fileDate = file.lastModified();
				Date d = new Date(fileDate);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
				
				System.out.print(sdf.format(d)+"\t");
				
				if(file.isDirectory()) {
					System.out.println("<DIR>"+"\t\t");
				}else {
					System.out.print("\t"+file.length()+"\t");
					System.out.print(file.getName());
				}
				System.out.println();
				
			}
		}
		
		
	}
}
