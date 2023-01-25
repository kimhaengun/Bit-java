package com.bit;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

class Student {
	private int stuNum; //학번
	private int korNum; //국어 점수
	private int engNum; //영어 점수
	private int mathNum; //수학 점수

	public Student(int stuNum, int korNum, int engNum, int mathNum) {
		// TODO Auto-generated constructor stub
		this.stuNum = stuNum;
		this.korNum = korNum;
		this.engNum = engNum;
		this.mathNum = mathNum;
	}

	public Student() {

	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getKorNum() {
		return korNum;
	}

	public void setKorNum(int korNum) {
		this.korNum = korNum;
	}

	public int getEngNum() {
		return engNum;
	}

	public void setEngNum(int engNum) {
		this.engNum = engNum;
	}

	public int getMathNum() {
		return mathNum;
	}

	public void setMathNum(int mathNum) {
		this.mathNum = mathNum;
	}

}

public class Ex09 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);
		int input = 0;
		int stuNum, korNum, engNum, mathNum;
		System.out.println("학생 정보 시스템");
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> studentList = new ArrayList<Student>();

		String addr = "127.0.0.1";
		MongoClient client = null;
		
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("lec32");
			MongoCollection<Document> coll = db.getCollection("student");
			FindIterable<Document> rs = coll.find();
			MongoCursor<Document> ite = rs.iterator();
			while(ite.hasNext()) {
				Student stu = new Student();
				Document doc = ite.next();
				stu.setStuNum(doc.getInteger("stunum"));
				stu.setKorNum(doc.getInteger("kornum"));
				stu.setEngNum(doc.getInteger("engnum"));
				stu.setMathNum(doc.getInteger("mathnum"));
				studentList.add(stu);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			client.close();
		}
		
		while (true) {
			try {
				System.out.print("1.리스트  2.상세보기 3.입력 4.수정 5.삭제 0.종료 >");
				input = sc.nextInt();
				boolean stuSearchBoo=false;
				// 리스트
				if (input == 1) {
					System.out.println("리스트");
					System.out.println("================================");
					System.out.println("학번\t국어\t영어\t수학");
					System.out.println("================================");
					findAll();

				}
				//상세보기
				if (input == 2) {
					System.out.println("상세보기");
					System.out.print("학번 >");
					input = sc.nextInt();

					int indNum = 0;
					// ex)학번 : 2017의 index찾기
					for (int i = 0; i < studentList.size(); i++) {
						if (input == studentList.get(i).getStuNum()) {
							// 해당 값의 index
							indNum = i;
							stuSearchBoo=true;
						}
					}
					if(stuSearchBoo == false) {
		            	   System.out.println("해당 학생이 없습니다.");
		            	   continue;
		               }
					for (int j = 0; j < 1; j++) {
						int sum = 0;
						int studentKorNum = studentList.get(indNum).getKorNum();
						int studentEngNum = studentList.get(indNum).getEngNum();
						int studentMathNum = studentList.get(indNum).getMathNum();
						// 각 과목의 점수 출력
						System.out.println("국어 : " + studentKorNum);
						System.out.println("영어 : " + studentEngNum);
						System.out.println("수학 : " + studentMathNum);

						// 학생 합계 구하기
						sum = studentKorNum + studentEngNum + studentMathNum;
						double avg = (sum * 100 / 3 / 100.0);

						int allKorScore = 0, allEngScore = 0, allMathScore = 0, allSum = 0;
						double allAvg;
						for (int i = 0; i < studentList.size(); i++) {
							allKorScore += studentList.get(i).getKorNum();
							allEngScore += studentList.get(i).getEngNum();
							allMathScore += studentList.get(i).getMathNum();
						}
						allSum = allKorScore + allEngScore + allMathScore;
						allAvg = (allSum * 100 / 3 / studentList.size() / 100.0);

						int gradeAvg = (int) avg;
						char grade;
						if (100 >= gradeAvg && gradeAvg >= 90) {
							grade = 'A';
						} else if (90 > gradeAvg && gradeAvg >= 80) {
							grade = 'B';
						} else if (80 > gradeAvg && gradeAvg >= 70) {
							grade = 'C';
						} else if (70 > gradeAvg && gradeAvg >= 60) {
							grade = 'D';
						} else {
							grade = 'F';
						}
						System.out.println("학생 합계:" + sum + " 평균:" + avg + " 전체 평균:" + allAvg + " 학점:" + grade);

					}
					//입력
				}if (input == 3) {
						boolean boo = false;
						System.out.println("입력");
						System.out.print("학번 >");
						stuNum = sc.nextInt();
						for (int i = 0; i < studentList.size(); i++) {
							if(stuNum == studentList.get(i).getStuNum()) {
								System.out.println("동일한 학번이 존재합니다.");
								boo = true;
							}
						}
						if(boo==true) {
							continue;
						}
						System.out.print("국어 >");
						korNum = sc.nextInt();
						System.out.print("영어 >");
						engNum = sc.nextInt();
						System.out.print("수학 >");
						mathNum = sc.nextInt();
						if((0>korNum||korNum>100)||(0>engNum||engNum>100)||(0>mathNum||mathNum>100)) {
							System.out.println("0~100자리 숫자를 입력하시기 바랍니다.");
							continue;
						}
						
						Student stu = new Student(stuNum, korNum, engNum, mathNum);
						studentList.add(stu);
						save(stu);
						System.out.println("학번"+stu.getStuNum()+"등록 되었습니다.");
					}
					//수정
					if (input == 4) {
						System.out.print("수정 학번 >");
						int updateStuNum = sc.nextInt();
			               for (int i = 0; i < studentList.size(); i++) {
			                   if(updateStuNum==studentList.get(i).getStuNum()) {
			                      System.out.println("국어 :"+studentList.get(i).getKorNum());
			                      System.out.println("영어 :"+studentList.get(i).getEngNum());
			                      System.out.println("수학 :"+studentList.get(i).getMathNum());
			                      System.out.print("1.국어 2.영어 3.수학 >");
			                      input = sc.nextInt();
			                      int subjectNum = 0;
			                      if(input==1) {
			                         System.out.print("국어>");
			                         subjectNum = sc.nextInt();
			                         studentList.get(i).setKorNum(subjectNum);
			                      }
			                      if(input==2) {
			                    	  System.out.print("영어>");
			                    	  subjectNum = sc.nextInt();
			                         studentList.get(i).setEngNum(subjectNum);                                             
			                      }
			                      if(input==3) {
			                         System.out.print("수학>");
			                         subjectNum = sc.nextInt();
			                         studentList.get(i).setMathNum(subjectNum);
			                      }
			                      if(0>subjectNum||subjectNum>100) {
			                    	  System.out.println("0~100자리 숫자를 입력하시기 바랍니다.");
										continue;
			                      }
			                      update(updateStuNum,input,subjectNum);
			                      stuSearchBoo=true;
			                   }
			                   
			                }
			               if(stuSearchBoo == false) {
			            	   System.out.println("해당 학생이 없습니다.");
			               }
						
					}
					//삭제
					if (input == 5) {
						System.out.print("삭제 학번 >");
						input = sc.nextInt();

						for (int i = 0; i < studentList.size(); i++) {
							if (input == studentList.get(i).getStuNum()) {
								studentList.remove(i);
								delete(input);
								System.out.println("학번"+input+"이 삭제 되었습니다.");
								stuSearchBoo=true;
							}
						}
						if(stuSearchBoo == false) {
			            	   System.out.println("해당 학생이 없습니다.");
			               }
					}
					//종료
					if (input == 0) {
						System.out.println("종료");
						break;
					}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자를 입력해 주세요");
				break;
			} //try end
		}
		
	}//while end

	private static void findAll() {
		// TODO Auto-generated method stub
		String addr = "127.0.0.1";
		MongoClient client = null;
		
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("lec32");
			MongoCollection<Document> coll = db.getCollection("student");
			FindIterable<Document> rs = coll.find();
			MongoCursor<Document> ite = rs.iterator();
			while(ite.hasNext()) {
				Document doc = ite.next();
				System.out.print(doc.get("stunum")+"\t");
				System.out.print(doc.get("kornum")+"\t");
				System.out.print(doc.get("engnum")+"\t");
				System.out.print(doc.get("mathnum")+"\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			client.close();
		}
	}

	//학생 수정
	private static void update(int updateStuNum,int input, int subjectNum) {
		// TODO Auto-generated method stub
		String subject = "";
		if(input == 1) {
			subject = "kornum";
		}
		if(input == 2) {
			subject = "engnum";
		}
		if(input == 3) {
			subject = "mathnum";
		}
		String addr = "127.0.0.1";
		MongoClient client = null;
		
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("lec32");
			MongoCollection<Document> coll = db.getCollection("student");
			//updateOne
			Document doc1 = new Document();
			doc1.append("stunum", updateStuNum);
			Document doc2 = new Document();
			Document doc3 = new Document();
			doc3.append(subject, subjectNum);
			doc2.append("$set", doc3);
			
			coll.updateOne(doc1,doc2);
			System.out.println("학번"+updateStuNum+"의 "+subject+"점수가 "+subjectNum+"로 변경되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			client.close();
		}
		

	} //update end

	//학생 DB 삭제
	private static void delete(int input) {
		String addr = "127.0.0.1";
		MongoClient client = null;
		
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("lec32");
			MongoCollection<Document> coll = db.getCollection("student");
			//Document = BSON 생성
			Document doc = new Document();
			doc.append("stunum", input);
			
			coll.deleteMany(doc);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			client.close();
		}
		
	}//delete end
	
	//학생 DB 저장
	private static void save(Student stu) {
		String addr = "127.0.0.1";
		MongoClient client = null;
		
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("lec32");
			MongoCollection<Document> coll = db.getCollection("student");
			//Document = BSON 생성
			Document doc = new Document();
			doc.append("stunum", stu.getStuNum());
			doc.append("kornum", stu.getKorNum());
			doc.append("engnum", stu.getEngNum());
			doc.append("mathnum", stu.getMathNum());
			coll.insertOne(doc);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			client.close();
		}
	}// save_mysql() end
	
}