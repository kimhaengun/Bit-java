package com.bit;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class Ex01 {
	public static void main(String[] args) {
		Driver driver;
		java.sql.Connection conn = null;
		Statement stmt = null;
		try {
			
			//Driver 생성
			driver = new Driver();
			System.out.println(driver);
			
			//Connection 객체 생성
			String url ="jdbc:mysql://localhost:3306/lecture";
			Properties props=null;
			props = new Properties();
			props.setProperty("user", "scott");
			props.setProperty("password", "tiger");
			conn = DriverManager.getConnection(url,props);
			
//			String sql = "insert into dept (deptno, dname, loc) values(50,'물류','부산')";
//			String sql = "update dept set dname = '전산' where deptno = '50'";
			String sql = "delete from dept where deptno = 50";
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//				e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
