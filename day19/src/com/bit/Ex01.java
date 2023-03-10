package com.bit;

import java.awt.List;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Student {
	int stuNum, korNum, engNum, mathNum;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int stuNum, int korNum, int engNum, int mathNum) {
		// TODO Auto-generated constructor stub
		this.stuNum = stuNum;
		this.korNum = korNum;
		this.engNum = engNum;
		this.mathNum = mathNum;
	}
	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", korNum=" + korNum + ", engNum=" + engNum + ", mathNum=" + mathNum + "]";
	}
	
}

public class Ex01 {

	public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println("==학생 성적 관리==");
//      ArrayList<Student> studentList = new ArrayList<Student>();
      Map<Integer, Student> studentList = new HashMap<Integer, Student>();
      int input = 0;
      boolean boo = true;
      Scanner sc = new Scanner(System.in);
      Student student;
  	  File f = new File("studentList.txt");
  	  InputStream is = null;
  	  BufferedInputStream bis = null;
      OutputStream os = null;       
      BufferedOutputStream bos = null;  
      do{
         try {
        	 String inputStr = "";
        	 HashMap<Integer, Object> studentMap = new HashMap<Integer, Object>();
        	 if(f.exists()&&f.length()>0) {
        	 
             is = new FileInputStream(f);
             bis = new BufferedInputStream(is);
             while(true) {
                int su = bis.read();
                if(su==-1)break;
                char change = (char)su;
				inputStr += String.valueOf(change);
             }      	
				String[] inputStrArr = inputStr.split(",");
				String[] result = new String[4];
				for (int i = 0; i < inputStrArr.length; i++) {
   				String[] inputStrArr2 = inputStrArr[i].split("\t");
   				
					for (int j = 0; j < inputStrArr2.length; j++) { 
						result[j] = inputStrArr2[j];
					}
					student = new Student(Integer.parseInt(result[0]), 
							Integer.parseInt(result[1]), 
							Integer.parseInt(result[2]), 
							Integer.parseInt(result[3])); 
					studentMap.put(Integer.parseInt(result[0]), student);
				}
				
				if(bis!=null)bis.close();
                if(is!=null)is.close();
        	 }
        	 
            System.out.print("1.목록 2.상세보기 3.입력 4.수정 5.삭제 0.종료 >");
            input = sc.nextInt();
            
        
            if(input==1) { //목록
               System.out.println("===========================");
               System.out.println("학번\t국어\t영어\t수학");

               if(f.exists()&&f.length()>0) {
     				String[] inputStrArr = inputStr.split(",");
     				for (int i = 0; i < inputStrArr.length; i++) {

						System.out.println(inputStrArr[i]);	
					}
               }else {
            	   System.out.println("데이터가 없습니다.");
               }
                  
               
               System.out.println("===========================");
            
            }else if(input==2) { // 상세보기
            	try {
                    System.out.println("상세보기");
                    System.out.print("학번>");
                    input = sc.nextInt();
                    Student s = null;
                    int korScore = 0, engScore = 0, mathScore = 0 ,sum;
                    int allKorScore = 0, allEngScore = 0, allMathScore = 0 ,allSum = 0;
                    double avg, allAvg;
                    char grade;
                    ArrayList keyList = new ArrayList(studentMap.keySet());

                    for (int i = 0; i < studentMap.size(); i++) {
                 	   
                 	   if(input == (int)keyList.get(i)) { //2018 == map.key
                 		   s = (Student)studentMap.get(input);
                 		  korScore = s.korNum; 
                 		  engScore = s.engNum;
                 		  mathScore = s.mathNum;
                 	   }

     				}
                    for (int i = 0; i < studentMap.size(); i++) {
                    	s = (Student)studentMap.get(keyList.get(i));
          				allKorScore+=s.korNum;
          				allEngScore+=s.engNum;
          				allMathScore+=s.mathNum;
					}
                    sum = korScore+engScore+mathScore;
                    avg = (sum*100/3/100.0);
                    allSum = allKorScore+allEngScore+allMathScore;
                    allAvg = (allSum*100/3/studentMap.size()/100.0);
                    
					int gradeAvg = (int)avg;
					
					if(100>=gradeAvg&&gradeAvg>=90) {
						grade='A';
					}else if(90>gradeAvg&&gradeAvg>=80){
						grade='B';
					}else if(80>gradeAvg&&gradeAvg>=70){
						grade='C';
					}else if(70>gradeAvg&&gradeAvg>=60){
						grade='D';
					}else {
						grade='F';
					}

                    System.out.println("국어:"+korScore);
                    System.out.println("영어:"+engScore);
                    System.out.println("수학:"+mathScore);
                    System.out.println("합계:"+sum+" ("+avg+" / "+allAvg+")" +" 학점:"+grade);
                    continue;
				} catch (Exception e) {
					// 입력한 학번의 학생이 없을 경우 Exception
					System.out.println("해당 학생이 없습니다.");
				}

            }else if(input==3) { //입력
            		inputStr = "";
            		//txt 파일 없을 경우 생성
            		if(!f.exists()) {
						f.createNewFile();
            			}
					// txt파일이 존재하면 길이를 측정하여 
            		// 내용이 있을 경우 기존 데이터 가져오기
            		if(f.exists()&&f.length()>0) {
            			is = new FileInputStream(f);
            			bis = new BufferedInputStream(is);
            			while(true) {
            				int su = bis.read();
            				if(su==-1)break;
            				char change = (char)su;
            				inputStr += String.valueOf(change);
            			}
        				if(bis!=null)bis.close();
        				if(is!=null)is.close();
            		}
            	
               student = new Student();
               System.out.print("학번 >");
               input = sc.nextInt();
//               student.stuNum = input;
               
               System.out.print("국어 >");
               int korScore = sc.nextInt();
               student.korNum = korScore;
               
               System.out.print("영어 >");
               int engScore = sc.nextInt();
               student.engNum = engScore;
               
               System.out.print("수학 >");
               int mathScore = sc.nextInt();
               student.mathNum = mathScore;
               
               if(korScore<0) {
            	   
               }
               
               studentList.put(input, student); // key:학번, value:Student Object
               
               String msg = input+"\t"+korScore+"\t"+engScore+"\t"+mathScore+",";
               
               byte[] arr = msg.getBytes(); //input 값 arr에 담기
               int su = -1;
                  if(f.length()<=0) { // 첫 학생 추가일 경우
                      os = new FileOutputStream(f);
                      os.write(arr);
                      if(os!=null) os.close();
                      
                   }else {  // 이미 학생이 있을 경우
                	   os = new FileOutputStream(f);
                	   msg += inputStr;
                	   arr = msg.getBytes();
                	   os.write(arr);
                       if(os!=null) os.close();
                   }
                  System.out.println("txt 작성 완료");
               
            }else if(input==4) { //수정
               System.out.print("학번>");
               input = sc.nextInt();
               Student s;
               String sSum, kSum,eSum,mSum, aSum="";
               ArrayList keyList = new ArrayList(studentMap.keySet());
               
               for (int i = 0; i < studentMap.size(); i++) {
            	   
            	   if(studentMap.containsKey(input)) { //2018 == map.key
       				s = (Student)studentMap.get(input);
    				sSum = String.valueOf(s.stuNum);
    				kSum = String.valueOf(s.korNum);
    				eSum = String.valueOf(s.engNum);
    				mSum = String.valueOf(s.mathNum);
            		System.out.println("국어 : "+kSum+" 영어: "+eSum+" 수학: "+mSum);
            		System.out.print("1.국어 2.영어 3.수학 >");
            		input = sc.nextInt();
       				//여기서 값바꾸고
            		switch (input) {
					case 1:
						System.out.print("국어 >");
						input = sc.nextInt();
						s.korNum = input;
						break;
					case 2:
						System.out.print("영어 >");
						input = sc.nextInt();
						s.engNum = input;
						break;
					case 3:
						System.out.print("수학 >");
						input = sc.nextInt();
						s.mathNum = input;
						break;
					default:
						System.out.println("1~3 숫자를 입력해 주세요");
						break;
					}
            	   }
            	   	student = (Student)studentMap.get(keyList.get(i));
   					sSum = String.valueOf(student.stuNum);
   					kSum = String.valueOf(student.korNum);
   					eSum = String.valueOf(student.engNum);
   					mSum = String.valueOf(student.mathNum);
   					aSum = aSum+sSum+"\t"+kSum+"\t"+eSum+"\t"+mSum+",";
      				
					}
               byte[] arr = aSum.getBytes();
               int su = -1;
               if(aSum.length()>0) {
                   os = new FileOutputStream(f);
                   os.write(arr);
                   
                   System.out.println("txt 변경 쓰기 완료");
               }
               System.out.println("변경 end!!!!!");
              
              
              if(os!=null) os.close(); 
              
            }else if(input==5) { //삭제
               System.out.print("학번>");
               input = sc.nextInt(); //2017
               Student s;
               String sSum, kSum,eSum,mSum, aSum="";

               for (int i = 0; i < studentMap.size(); i++) {
            	   
            	   if(studentMap.containsKey(input)) { //2018 == map.key
            		  studentMap.remove(input);
            		System.out.println("학번:"+input+" 삭제 완료");
            	   }
			   }
               ArrayList keyList = new ArrayList(studentMap.keySet());
               for (int i = 0; i < studentMap.size(); i++) {
            	   student = (Student)studentMap.get(keyList.get(i));
  					aSum +=student.stuNum+"\t"+student.korNum+"\t"+student.engNum+"\t"+student.mathNum+",";
               }
               byte[] arr = aSum.getBytes();
               int su = -1;
               if(aSum.length()>0) {
                   os = new FileOutputStream(f);
                   os.write(arr);
                   
                   System.out.println("삭제된 데이터 빼고 쓰기 완료");
               }
               System.out.println("삭제완료!!!!");
              
              
              if(os!=null) os.close(); 
               
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

         } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      }while(boo);
   }

}