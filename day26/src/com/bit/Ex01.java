package com.bit;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Ex01 {

	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
//		Set<String> keys = env.keySet();
//		Iterator<String> ite = keys.iterator();
//		while(ite.hasNext()) {
//			System.out.println(ite.next());
//		}		
		String sql = "select empno, ename, hiredate, sal+ifnull(comm,0) as money from emp";
		String url = "jdbc:mysql://localhost:3306/lecture";
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,info);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("사번\t이름\t입사일\t\t연봉");
			while(rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("문법 오류 또는 실행 오류");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 없어여");
		}
		finally {
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
