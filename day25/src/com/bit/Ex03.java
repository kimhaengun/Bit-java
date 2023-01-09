package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사번 >");
		String input = sc.nextLine();

		String sql = "select empno,ename,sal,deptno from emp where empno = "+input;
		String url = "jdbc:mysql://localhost:3306/lecture";
		Properties info = new Properties();
		info.setProperty("user", "scott");
		info.setProperty("password", "tiger");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result ;
		//사번을 입력 받아서 emp의 empno,ename,sql을 출력하시오
		try {
		
				Driver driver = new Driver();
				conn = DriverManager.getConnection(url,info);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql); //return은 resultSet을 반환함;
				while(rs.next()) {
					System.out.print(rs.getObject(1)+"\t");
					System.out.print(rs.getObject(2)+"\t");
					System.out.print(rs.getObject(3)+"\t");
					System.out.println(rs.getObject(4));
				}
				System.out.print("변경할 부서 번호 >");
				input = sc.nextLine();
				String  sql2 = "update from emp set deptno = "+input+" where deptno";
				result = stmt.executeUpdate(sql);		
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
	}
}
