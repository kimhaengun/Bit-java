package com.stu03;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex03 {
	public static void save() {
		OutputStream os = null;
		try {
			if(!f.exists()) f.createNewFile();
			os = new FileOutputStream(f);
			
			for (int i = 0; i < data.size(); i++) {
				int[] arr = data.get(i);
				os.write(Arrays.toString(arr).getBytes());						
			}
			
			if(os!=null)os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//프로그램을 켰을때 data 초기화
	public static void init() {
		int input = 0;
		if(f.exists()) {
			InputStream is = null;
			ArrayList<Byte> arr2 =new ArrayList<Byte>();
			try {
				is = new FileInputStream(f);
				while((input = is.read())!=-1) {
					arr2.add((byte) input);
				}
				
				if(is!=null) is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object[] arr3 = arr2.toArray();
			byte[] arr4 = new byte[arr3.length];
			for (int i = 0; i < arr3.length; i++) {
				arr4[i] = (byte) arr3[i];
			}
			String msg = new String(arr4);
			if(!msg.isEmpty()) {
				msg = msg.substring(1, msg.length()-1);
				String[] arr5 = msg.split("\\]\\[");
				for (int i = 0; i < arr5.length; i++) {
					String stu = arr5[i];
					String[] arr6 = stu.split(", ");
					int[] arr7 = new int[arr6.length];
					for (int j = 0; j < arr7.length; j++) {
						arr7[j]=Integer.parseInt(arr6[j]);
					}
					data.add(arr7);
				}
				
			}
		}
	}
	static List<int[]> data = new ArrayList<>();
	static File f = new File("./src/com/stu03/data.bin");
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(ver 0.5.3)");
		Scanner sc = new Scanner(System.in);
		int input = -1;
		init();
		while(true) {
			System.out.print("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료>");
			input = sc.nextInt();
			if(input==0) break;
			if(input==1) {
				
				System.out.println("===================================================");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("===================================================");
				for (int i = 0; i < data.size(); i++) {
					System.out.println(Arrays.toString(data.get(i)));
				}
				System.out.println("\n===================================================");
			}
			if(input==2) {
				
				
			}
			if(input==3) { //입력
				int[] stu = new int[4];
				System.out.print("학번>");
				stu[0]=sc.nextInt();
				
				System.out.print("국어>");
				stu[1]=sc.nextInt();
				
				System.out.print("영어>");
				stu[2]=sc.nextInt();
				
				System.out.print("수학>");
				stu[3]=sc.nextInt();
				
				data.add(stu);
				save();
				
			}
			if(input==4) {
				
			}
			if(input==5) {
				
			}
		}
	}

}
