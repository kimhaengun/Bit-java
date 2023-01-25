package com.bit;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

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
	
		int input = 0;
		int stuNum, korNum, engNum, mathNum;
		System.out.println("학생 정보 시스템");
		Scanner sc = new Scanner(System.in);

		ArrayList<Student> studentList = new ArrayList<Student>();

		//학생 List 받아와서 ArrayList에 담기
		String url = "jdbc:mysql://localhost:3306/lecture";
		Map<String, String> env = System.getenv();
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT stunum, kornum, engnum, mathnum FROM student ORDER BY stunum desc";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student st = new Student();
				st.setStuNum(rs.getInt(1));
				st.setKorNum(rs.getInt(2));
				st.setEngNum(rs.getInt(3));
				st.setMathNum(rs.getInt(4));
				studentList.add(st);
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} //try end

		while (true) {
			try {
				System.out.print("1.리스트  2.상세보기 3.입력 4.수정 5.삭제 0.종료 >");
				input = sc.nextInt();
				// 리스트
				if (input == 1) {
					System.out.println("리스트");
					System.out.println("================================");
					System.out.println("학번\t국어\t영어\t수학");
					System.out.println("================================");
					for (int i = 0; i < studentList.size(); i++) {
						System.out.print(studentList.get(i).getStuNum() + "\t" + studentList.get(i).getKorNum() + "\t"
								+ studentList.get(i).getEngNum() + "\t" + studentList.get(i).getMathNum() + "\n");
					}

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
							System.out.println("인덱스 번호 : " + i);
						}
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
						Student stu = new Student(stuNum, korNum, engNum, mathNum);
						studentList.add(stu);
						save(stu);

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
			                         System.out.println("국어>");
			                         subjectNum = sc.nextInt();
			                         studentList.get(i).setKorNum(subjectNum);
			                      }
			                      if(input==2) {
			                    	  System.out.println("영어>");
			                    	  subjectNum = sc.nextInt();
			                         studentList.get(i).setEngNum(subjectNum);                                             
			                      }
			                      if(input==3) {
			                         System.out.println("수학>");
			                         subjectNum = sc.nextInt();
			                         studentList.get(i).setMathNum(subjectNum);;
			                      }
			                      
			                      update(updateStuNum,input,subjectNum);

			                   }
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
							}
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
		
		String url = "jdbc:mysql://localhost:3306/lecture";
		Map<String, String> env = System.getenv();
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			String sql = "UPDATE student SET "+subject+"="+subjectNum+" WHERE stunum="+updateStuNum;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println(input+"학생 수정 완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	} //update end

	//학생 DB 삭제
	private static void delete(int input) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/lecture";
		Map<String, String> env = System.getenv();
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			String sql = "DELETE From student WHERE stunum = "+input;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println(input+"학생 삭제 완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}//delete end
	
	//학생 DB 저장
	private static void save(Student stu) {
		// TODO Auto-generated method stub
		// mysql

		String url = "jdbc:mysql://localhost:3306/lecture";
		Map<String, String> env = System.getenv();
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			String sql = "insert into student (stunum, kornum, engnum, mathnum) values (";
			sql += stu.getStuNum() + "," + stu.getKorNum() + "," + stu.getEngNum() + "," + stu.getMathNum() + ");";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("입력 끝");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}// save_mysql() end
	
}