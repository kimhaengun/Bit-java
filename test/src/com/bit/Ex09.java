//package com.bit;
//
//import java.io.EOFException;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//class StudentInfo implements Serializable{
//
//   private static final long serialVersionUID = 1L;
//   int stuNum;
//   int korScore, engScore, mathScore;
//   
//}
//public class Ex09 {
//   
//   public static void main(String[] args) {
//      System.out.println("학생성적관리프로그램(ver 0.5.0)");
//      Scanner sc = new Scanner(System.in);
//      int input;
////      
//      OutputStream os = null;
//      InputStream is = null;
//      ObjectOutputStream oos = null;
//      ObjectInputStream ois = null;
//      StudentInfo studentInfo;
//      ArrayList<StudentInfo> studentList;
//      
//
//      while(true){
//         try {
//            File f = new File("studentList.txt");
//            studentList = new ArrayList<StudentInfo>();
//            if(f.exists()) {
//               try {
//                  is = new FileInputStream(f);
//                  ois = new ObjectInputStream(is);
//                  studentList = (ArrayList<StudentInfo>)ois.readObject();
//               } catch (EOFException e1) {
//                  // TODO Auto-generated catch block
//       
//               } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//               }   
//            }
//            
//            System.out.print("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료");
//            input = sc.nextInt();
//            if(input==0) { //시스템 종료
//               System.out.println("시스템이 종료됩니다.");
//               break; 
//            }
//            else if(input==1) { //리스트
//               try {
//                  System.out.println("===================================================");
//                  System.out.println("학번\t국어\t영어\t수학");
//                  for (int i = 0; i < studentList.size(); i++) {
//                     System.out.print(studentList.get(i).stuNum+"\t"
//                           +studentList.get(i).korScore+"\t"
//                           +studentList.get(i).engScore+"\t"
//                           +studentList.get(i).mathScore+"\t");
//                     System.out.println();
//                  }
//
//                  System.out.println("===================================================");
//
//
//               }catch (Exception e) {
//                  // TODO: handle exception
//                  System.out.println(e);
//               }
//            }
//            
//            else if(input==2) { //보기
//               System.out.print("학번 >");
//               input = sc.nextInt();
//               int kScore =0, eScore=0, mScore=0;
//               for (int i = 0; i < studentList.size(); i++) {
//                   if(input==studentList.get(i).stuNum) {
//                      System.out.println("국어 :"+studentList.get(i).korScore);
//                      kScore = studentList.get(i).korScore;
//                      System.out.println("영어 :"+studentList.get(i).engScore);
//                      eScore = studentList.get(i).engScore;
//                      System.out.println("수학 :"+studentList.get(i).mathScore);
//                      mScore = studentList.get(i).mathScore;
//                   }
//                }
//               int sum = kScore+eScore+mScore;
//               double avg = (sum*100/3/100.0);
//               
//               int allKorScore =0, allEngScore = 0, allMathScore=0, allSum=0;
//               double allAvg;
//               for (int i = 0; i < studentList.size(); i++) {
//                  allKorScore+=studentList.get(i).korScore;
//                  allEngScore+=studentList.get(i).engScore;
//                  allMathScore+=studentList.get(i).mathScore;
//               }
//               allSum = allKorScore+allEngScore+allMathScore;
//               allAvg = (allSum*100/3/studentList.size()/100.0);
//                
//               int gradeAvg = (int)avg;
//               char grade;
//              if(100>=gradeAvg&&gradeAvg>=90) {
//                 grade='A';
//              }else if(90>gradeAvg&&gradeAvg>=80){
//                 grade='B';
//              }else if(80>gradeAvg&&gradeAvg>=70){
//                 grade='C';
//              }else if(70>gradeAvg&&gradeAvg>=60){
//                 grade='D';
//              }else {
//                 grade='F';
//              }
//               
//               System.out.println("학생 합계:"+sum +" 평균:"+avg+ " 전체 평균:"+allAvg+" 학점:"+grade);
//            }
//            else if(input==3) { //입력
//               
//               os = new FileOutputStream(f);
//               oos = new ObjectOutputStream(os); 
//               studentInfo = new StudentInfo();
//               
//               System.out.print("학번 >");
//               studentInfo.stuNum = sc.nextInt();
//               System.out.print("국어 >");
//               studentInfo.korScore = sc.nextInt();
//               System.out.print("영어 >");
//               studentInfo.engScore = sc.nextInt();
//               System.out.print("수학 >");
//               studentInfo.mathScore = sc.nextInt();
//               
//               studentList.add(studentInfo);
//               
//               oos.writeObject(studentList);
//
//            }
//            else if(input==4) { //수정
//               System.out.print("학번 >");
//               input = sc.nextInt();
//               
//               for (int i = 0; i < studentList.size(); i++) {
//                  if(input==studentList.get(i).stuNum) {
//                     System.out.println("국어 :"+studentList.get(i).korScore);
//                     System.out.println("영어 :"+studentList.get(i).engScore);
//                     System.out.println("수학 :"+studentList.get(i).mathScore);
//                     System.out.print("1.국어 2.영어 3.수학 >");
//                     input = sc.nextInt();
//                     if(input==1) {
//                        System.out.println("국어>");
//                        studentList.get(i).korScore = sc.nextInt();
//                        
//                     }
//                     if(input==2) {
//                        System.out.println("영어>");
//                        studentList.get(i).engScore = sc.nextInt();                                             
//                     }
//                     if(input==3) {
//                        System.out.println("수학>");
//                        studentList.get(i).mathScore = sc.nextInt();
//                     }
//                     os = new FileOutputStream(f);
//                     oos = new ObjectOutputStream(os);
//
//                     oos.writeObject(studentList);
//
//                  }
//               }
//            }
//            else if(input==5) { //삭제
//               System.out.print("학번 >");
//               input = sc.nextInt();
//               
//               for (int i = 0; i < studentList.size(); i++) {
//                  if(input==studentList.get(i).stuNum) {
//                     studentList.remove(i);
//                     
//                  }
//               }
//               os = new FileOutputStream(f);
//               oos = new ObjectOutputStream(os);
//               
//               
//               oos.writeObject(studentList);
//               
//
//            }
//            if(ois!=null)ois.close();
//            if(oos!=null)oos.close();
//            if(is!=null)is.close();
//            if(os!=null)os.close();
//
//         } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         } 
//         
//         
//      }
//   }
//}