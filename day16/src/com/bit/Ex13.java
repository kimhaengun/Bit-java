package com.bit;

import java.io.*;
/*
 * 삭제
 */
public class Ex13 {

	public static void main(String[] args) {
		File file = new File("test02");
		if(file.exists()) {
//			boolean boo = file.delete();
			boolean boo = file.delete();
			
			if(boo) {
				System.out.println("삭제 완료");
			}else {
				// 삭제 하려는 디렉토리에 하위 디렉토리가 존재하면 삭제 실패함
				// 명령어 창  --> rmdir /s 
				System.out.println("삭제 실패");
				System.out.println("하위도 모두 지우시겠습니까? Y");
				//자바는 전체 삭제가 없슴 
				File[] arr = file.listFiles();
				for (int i = 0; i < arr.length; i++) {
					arr[i].delete();
				}
				file.delete();
				System.out.println("삭제 완료");
			}
			System.out.println("");
		}else {
			System.out.println("파일 없음");
		}
	}
}
