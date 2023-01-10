package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		String url = "jdbc:mysql://localhost:3306/lecture";
		Map<String, String> env = System.getenv();
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql;
		String table = null;

		int inputNum;

		try {
			
			while (true) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, info);
				stmt = conn.createStatement();
				System.out.print("1.emp 2.dept 0.exit >");
				inputNum = sc.nextInt();
				switch (inputNum) {
				case 1:
					table = "emp";
					break;
				case 2:
					table = "dept";
					break;
				default:
					break;
				}
				// emp
				if (inputNum == 1) {
					System.out.print("1.list 2.insert 3.update(add Deptno) 4.delete >");
					inputNum = sc.nextInt();
					if (inputNum == 1) { //list
						sql = "select * from "+table;
						rs = stmt.executeQuery(sql);
						System.out.println("EMPNO\tENAME\tJOB\tMGR\tHIREDATE\t\tSAL\tCOMM\tDEPTNO");
						while(rs.next()) {
							System.out.print(rs.getString(1)+"\t");
							System.out.print(rs.getString(2)+"\t");
							System.out.print(rs.getString(3)+"\t");
							System.out.print(rs.getString(4)+"\t");
							System.out.print(rs.getString(5)+"\t");
							System.out.print(rs.getString(6)+"\t");
							System.out.print(rs.getString(7)+"\t");
							System.out.print(rs.getString(8)+"\n");
						}
						
					}
					if (inputNum == 2) {// insert
						
						System.out.print("사번 >");
						int num = Integer.parseInt(sc2.nextLine());
						System.out.print("이름 >");
						String name = sc2.nextLine();
						System.out.print("금액 >");
						int sal = Integer.parseInt(sc2.nextLine());
						System.out.print("커미션 >");
						int comm = Integer.parseInt(sc2.nextLine());
						
						sql = "insert into emp (empno, ename, hiredate, sal, comm) values ("+num+",'"+name+"', now(),"+sal+","+comm+");";
						System.out.println(sql);
						stmt.executeUpdate(sql);
							
						System.out.println("입력 되었습니다.");
							
						
						
					}
					if (inputNum == 3) { //3. update(add Deptno)
						System.out.println("===현재 dept의 deptNo 목록===");
						sql = "select deptno from dept;";
						rs = stmt.executeQuery(sql);
						System.out.println("EMPNO");
						while(rs.next()) {
							System.out.println(rs.getString(1));
						}

						System.out.println("===현재 empno의 deptNo 목록===");
						sql = "select empno, deptno from emp;";
						rs = stmt.executeQuery(sql);
						System.out.println("empno\tdeptno");
						while(rs.next()) {
							System.out.print(rs.getString(1)+"\t");
							System.out.print(rs.getString(2)+"\n");
						}
						
						System.out.print("변경 EMPNO >");
						inputNum = sc.nextInt();
						System.out.print("변경할 deptNo >");
						int deptno = sc.nextInt();
						sql = "update emp set deptno = "+deptno+" where empno = "+inputNum;
						stmt.executeUpdate(sql);
						System.out.println("변경 완료");
						
					} 
					if (inputNum == 4) { //4.delete
						System.out.println("emp empno 번호>");
						inputNum = sc.nextInt();
						sql="delete from emp where empno = "+inputNum;
						stmt.executeUpdate(sql);
						System.out.println("삭제 완료");
					}

				}

				// dept
				if (inputNum == 2) {
					System.out.print("1.list 2.insert 3.delete >");
					inputNum = sc.nextInt();
					if (inputNum == 1) {
						sql = "select * from "+table;
						rs = stmt.executeQuery(sql);
						System.out.println("DEPTNO\tDNAME\tLOC");
						while(rs.next()) {
							System.out.print(rs.getString(1)+"\t");
							System.out.print(rs.getString(2)+"\t");
							System.out.print(rs.getString(3)+"\n");
						}
					} else if (inputNum == 2) {
						System.out.print("DEPTNO >");
						int num = Integer.parseInt(sc2.nextLine());
						System.out.print("DNAME >");
						String name = sc2.nextLine();
						System.out.print("LOC>");
						String loc = sc2.nextLine();
						
						sql = "insert into dept (deptno, dname, loc) values ("+num+", '"+name+"', '" +loc+ "');";
						System.out.println(sql);
						stmt.executeUpdate(sql);
							
						System.out.println("입력 되었습니다.");
					} else if (inputNum == 3) {
						System.out.println("dept deptno 번호>");
						inputNum = sc.nextInt();
						sql="delete from dept where deptno = "+inputNum;
						stmt.executeUpdate(sql);
						System.out.println("삭제 완료");
					}
				}

				if (inputNum == 0) {
					break;
				}

			} // while end
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
