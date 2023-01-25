package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
   public static void main(String[] args) {
      Connection conn = null;
      try {
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lecture","scott","tiger");
         System.out.println("데이터 베이스 연결 성공");
         
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("데이터 베이스 연결 실패");
      }
      
   }
}