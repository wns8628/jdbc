package com.douzone.jdbc.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.jdbc.bookshop.vo.AuthorVo;

public class AuthorDao {
	
   public List<AuthorVo> getList() {
      List<AuthorVo> list = new ArrayList<AuthorVo>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();

         // 3. Staement 객체를 생성
         stmt = conn.createStatement();

         // 4. SQL문 실행
         String sql = "select no, name, bio from author";
         rs = stmt.executeQuery(sql);

         // 5. 결과 가져오기
         while (rs.next()) {
            Long no = rs.getLong(1);
            String name = rs.getString(2);
            String bio = rs.getString(3); // DB의 Date 타입을 java에서 Stirng으로 받는다.

            AuthorVo vo = new AuthorVo();
            vo.setNo(no);
            vo.setName(name);
            vo.setBio(bio);

            list.add(vo);
         }

      } catch (SQLException e) {
         System.out.println("error: " + e);
      } finally {
         try {
            if (rs != null) {
               rs.close();
            }
            if (stmt != null) {
               stmt.close();
            }
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return list;
   }

   public boolean insert(AuthorVo authorVo) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      boolean result = false;
      try {

         conn = getConnection();
         String sql = "insert " + "into author " + "values(null, ?, ?)";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, authorVo.getName());
         pstmt.setString(2, authorVo.getBio());

         int count = pstmt.executeUpdate();

         result = count == 1;
      }

      catch (SQLException e) {
         System.out.println("error: " + e);
      } finally {
         try {
            if (pstmt != null) {
               pstmt.close();
            }
            if (conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return result;
   }

   private Connection getConnection() throws SQLException {
      Connection conn = null;

      try {
         Class.forName("com.mysql.jdbc.Driver"); // 패키지 이름

         String url = "jdbc:mysql://localhost:3306/webdb"; // DB 종류마다 url이 다르다
         conn = DriverManager.getConnection(url, "webdb", "webdb"); // interface
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패" + e);
      }
      return conn;
   }
}