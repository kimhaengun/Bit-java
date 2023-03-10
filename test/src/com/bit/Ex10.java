package com.bit;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class StudentInfo implements Serializable{

   private static final long serialVersionUID = 1L;
   int stuNum;
   int korScore, engScore, mathScore;
   
}
public class Ex10 {
   
public static void main(String[] args) {
      System.out.println("학생성적관리프로그램(ver 0.5.0)");
      Scanner sc = new Scanner(System.in);
      int input;
//      
      
//      InputStream is = null;
      
//      ObjectInputStream ois = null;
      StudentInfo studentInfo;
      ArrayList<StudentInfo> studentList;
      

      while(true){
    	  
    	  
         try {
        		 
            File f = new File("studentList.txt");
            
            InputStream is = null;
            ObjectInputStream ois = null;
            
            studentList = new ArrayList<StudentInfo>();
            
            if(f.exists()) {
               try {
            	   
                  is = new FileInputStream(f);
                  try {
                  ois = new ObjectInputStream(is);
					studentList = (ArrayList<StudentInfo>)ois.readObject();
                  } catch (EOFException e) {
                	  
                  }
                  System.out.println("dddd");
               } catch (ClassNotFoundException e1) {
            	   System.out.println("q1");
                   e1.printStackTrace();
                }  catch (FileNotFoundException e) {
                	System.out.println("q2");
                    e.printStackTrace();
                 } catch (IOException e) {
                	 System.out.println("q");
                    e.printStackTrace();
                 } 
            }else {
               System.out.println("파일없음");
            }
            
            System.out.print("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료");
            input = sc.nextInt();
            if(input==0) { //시스템 종료
               System.out.println("시스템이 종료됩니다.");
               break; 
            }
            else if(input==1) { //리스트
               try {
                  System.out.println("===================================================");
                  System.out.println("학번\t국어\t영어\t수학");
                  for (int i = 0; i < studentList.size(); i++) {
                     System.out.print(studentList.get(i).stuNum+"\t"
                           +studentList.get(i).korScore+"\t"
                           +studentList.get(i).engScore+"\t"
                           +studentList.get(i).mathScore+"\t");
                     System.out.println();
                  }

                  System.out.println("===================================================");
                  if(ois!=null)ois.close();
                  if(is!=null)is.close();

               }catch (Exception e) {
                  // TODO: handle exception
                  System.out.println(e);
               }
            }
            
            else if(input==2) { //보기
               System.out.print("학번 >");
               input = sc.nextInt();
               
               
            }
            else if(input==3) { //입력
            	 OutputStream os = null;
            	 ObjectOutputStream oos = null;        
               os = new FileOutputStream(f);
               oos = new ObjectOutputStream(os);
               
               
               
               studentInfo = new StudentInfo();
               
               System.out.print("학번 >");
               studentInfo.stuNum = sc.nextInt();
               System.out.print("국어 >");
               studentInfo.korScore = sc.nextInt();
               System.out.print("영어 >");
               studentInfo.engScore = sc.nextInt();
               System.out.print("수학 >");
               studentInfo.mathScore = sc.nextInt();
               
               studentList.add(studentInfo);
               
               oos.writeObject(studentList);
               
               if(oos!=null)oos.close();
               if(oos!=null)os.close();
            }
            else if(input==4) { //수정
            	 OutputStream os = null;
            	 ObjectOutputStream oos = null;        
               System.out.print("학번 >");
               input = sc.nextInt();
               
               for (int i = 0; i < studentList.size(); i++) {
                  if(input==studentList.get(i).stuNum) {
                     System.out.println("국어 :"+studentList.get(i).korScore);
                     System.out.println("영어 :"+studentList.get(i).engScore);
                     System.out.println("수학 :"+studentList.get(i).mathScore);
                     System.out.print("1.국어 2.영어 3.수학 >");
                     input = sc.nextInt();
                     if(input==1) {
                        System.out.println("국어>");
                        studentList.get(i).korScore = sc.nextInt();
                        
                     }
                     if(input==2) {
                        System.out.println("영어>");
                        studentList.get(i).engScore = sc.nextInt();                                             
                     }
                     if(input==3) {
                        System.out.println("수학>");
                        studentList.get(i).mathScore = sc.nextInt();
                     }
                     os = new FileOutputStream(f);
                     oos = new ObjectOutputStream(os);
                     
                     
                     oos.writeObject(studentList);
                     
                     if(oos!=null)oos.close();
                     if(oos!=null)os.close();
                  }
               }
               
               
               
            }
            else if(input==5) { //삭제
            	 OutputStream os = null;
            	 ObjectOutputStream oos = null;        
               System.out.print("학번 >");
               input = sc.nextInt();
               
               for (int i = 0; i < studentList.size(); i++) {
                  if(input==studentList.get(i).stuNum) {
                     studentList.remove(i);
                     
                  }
               }
               os = new FileOutputStream(f);
               oos = new ObjectOutputStream(os);
               
               
               oos.writeObject(studentList);
               
               if(oos!=null)oos.close();
               if(oos!=null)os.close();
            }
            

//            if(oos!=null)oos.close();
//            if(os!=null)os.close();

         } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } 
         
         
      }
   }
}