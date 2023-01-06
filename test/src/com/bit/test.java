package com.bit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class Student{
   int stuNum, korNum, engNum, mathNum;
   
}


public class test {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println("==학생 성적 관리==");
//      ArrayList<Student> studentList = new ArrayList<Student>();
      Map<Integer, Student> studentList = new HashMap<Integer, Student>();
      int input = 0;
      boolean boo = true;
      Scanner sc = new Scanner(System.in);
      Student student;
      do{
         try {
            System.out.print("1.목록 2.삽입 3.수정 4.삭제 5.상세보기 0.종료 >");
            input = sc.nextInt();
            
            
            if(input==1) { //목록
               System.out.println("========================");
               File f = new File("studentList.txt");
               InputStream is = null ;
               BufferedInputStream bis = null;
               try {
                  
                  if(f.exists()) {
                     
                     is = new FileInputStream(f);
                     bis = new BufferedInputStream(is);
                     while(true) {
                        int su = bis.read();
                        if(su==-1)break;
                        System.out.print((char)su);
                     }
                  }
                  if(bis!=null)bis.close();
                  if(is!=null)is.close();
               } catch (FileNotFoundException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
               System.out.println("\n========================");
            
            }else if(input==2) { //삽입

               student = new Student();
               System.out.print("학번 > ");
               input = sc.nextInt();
//               student.stuNum = input;
               
               System.out.print("국어 > ");
               int korScore = sc.nextInt();
               student.korNum = korScore;
               
               System.out.print("영어 > ");
               int engScore = sc.nextInt();
               student.engNum = engScore;
               
               System.out.print("수학 > ");
               int mathScore = sc.nextInt();
               student.mathNum = mathScore;
               
               studentList.put(input, student); // key:학번, value:Student Object
//               studentList.add(student);
               
               File f = new File("studentList.txt");
               OutputStream os = null;
               InputStream is = null;
               BufferedInputStream bis = null;
               BufferedOutputStream bos = null;  

               String msg = input+"\t"+korScore+"\t"+engScore+"\t"+mathScore+"-";
               
               byte[] arr = msg.getBytes(); //input 값 arr에 담기
               int su = -1;

//               System.out.println("입력 : "+msg); 
               try {                  
                  if(f.exists()){
                	  // 기존 데이터 있을 시 가져와서 , 기존 데이터 + msg
                	  	System.out.println("기존 데이터 있음");
                        is = new FileInputStream(f); //기존 데이터 불러와서
                        os = new FileOutputStream(f); 
                        
                        bis=new BufferedInputStream(is);
                        bos=new BufferedOutputStream(os);
                        System.out.println("기존 데이터 읽는중");
                        String test = null;
                        boolean boo2 = true;
                        while(boo2) {
                        	//새로 다시 쓰기
                            su = bis.read();
                            if(su==-1)break;
                             test+= (char)su;
                        }
                        msg+=test;
                        boo2 = false;
                        byte[] resetMsg = msg.getBytes();
                        System.out.println("다시 쓰는 중");
                        System.out.print("fi :"+msg);
                        while(boo2==false) {
                        	bos.write(resetMsg);
                        }
                        
                        if(bos!=null)bos.close();
                        if(bis!=null)bis.close();
                        if(os!=null)os.close();
                        if(is!=null)is.close();
                        
                  		}
                  if(!f.exists()) {
                      //기존 리스트 txt없으면 생성
                      f.createNewFile();
                      os = new FileOutputStream(f);
                      System.out.println("base txt 생성");
                      os.write(arr);
                      if(os!=null) os.close();
                   }
                  System.out.println("txt 작성 완료");
                  
               } catch (FileNotFoundException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
               
               
            }else if(input==3) { //수정
               System.out.println("수정");
               
            }else if(input==4) { //삭제
               System.out.println("삭제");
               
            }else if(input==5) { // 상세보기
               System.out.println("상세보기");
               
            }else if(input==0) { // 종료
               System.out.println("종료");
               boo= false;
               
            }else {
               System.out.println("0~5숫자를 입력해주세요.");
            }
            
         }catch (InputMismatchException e) { //1.try
            // TODO: handle exception
            System.out.println("숫자만 입력 바랍니다.");
            break;

         }

      }while(boo);
   }

}