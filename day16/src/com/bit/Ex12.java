package com.bit;

import java.io.File;
import java.io.IOException;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".\\test02\\ex02.txt"); // 만약 test02가 없을 경우 부모 만들고 하위 만들어야함.
		if(file.exists()) {
			System.out.println("존재");
		}else {
			try {
				boolean boo = file.createNewFile();
				if(boo) {
					System.out.println("파일 생성");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
