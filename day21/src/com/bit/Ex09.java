package com.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Ex09 {

	public static void main(String[] args) {
		//Object stream
		OutputStream os = null;
		ObjectOutputStream  oos = null;
		try {
			os = new FileOutputStream("data09.bin");
			oos = new ObjectOutputStream(os);
			
			oos.writeInt(1234);
			oos.writeDouble(3.14);
			oos.writeBoolean(true);
			oos.writeUTF("문자열");
			int[] arr1 = {1,3,5,7,9};
			oos.writeObject(arr1);
			
			Vector arr2 = new Vector();
			arr2.add(1234);
			arr2.add(3.14);
			arr2.add(true);
			arr2.add('A');
			arr2.add("여기까지");
			oos.writeObject(arr2);
			
			ArrayList arr3 = new ArrayList();
			arr3.add(43212);
			arr3.add(4.14);
			arr3.add("arrayList");
			oos.writeObject(arr3);
			
			ArrayList arr4 = new ArrayList();
			arr4.addAll(arr3);
			arr4.add(55555);
			arr4.add(arr3);
			oos.writeObject(arr4);

			Set arr5 = new HashSet();
			arr5.addAll(arr3);
			arr5.add(55555);
			arr5.add(arr3);
			oos.writeObject(arr5);
			
			
			
			
			
			if(oos!=null)oos.close();
			if(os!=null)os.close();
			System.out.println("작성..");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
