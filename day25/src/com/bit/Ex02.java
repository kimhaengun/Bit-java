package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class Ex02 {

	public static void main(String[] args) {
		String sql = "select deptno,dname,loc from dept";
		String url = "jdbc:mysql://localhost:3306/lecture";
		Properties info = new Properties();
		info.setProperty("user", "scott");
		info.setProperty("password", "tiger");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Driver driver = new Driver();
			conn = DriverManager.getConnection(url,info);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //return은 resultSet을 반환함
			while(rs.next()) {
				System.out.print(rs.getObject(1)+"\t");
				System.out.print(rs.getObject(2)+"\t");
				System.out.println(rs.getObject(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
