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
import com.douzone.jdbc.bookshop.vo.BookVo;

public class BookDao {
	

	public List<BookVo> getList(){
		
	      List<BookVo> list = new ArrayList<BookVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select a.no, a.title, a.status, b.name" + 
	         		"    from book a, author b" + 
	         		"   where a.no2 = b.no" + 
	         		" order by a.no asc;";
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 long no = rs.getLong(1);
	        	 String title = rs.getString(2);
	        	 String status = rs.getString(3);
	        	 String author = rs.getString(4);
	        	 
	        	 BookVo vo= new BookVo();
	        	 vo.setNo(no);
	        	 vo.setTitle(title);
	        	 vo.setStatus(status);
	        	 vo.setAuthorName(author);
	        	 
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
	
	public void select_Rent(long no){
		
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      String title = null;
	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select title from book where no="+no;
	         rs = stmt.executeQuery(sql);
	         
	         if(rs.next()) {
	        	 title = rs.getString(1);     
	        	 System.out.println(title + "이(가) 대여 됐습니다.");	 
	         }else{
	         	 System.out.println("그런책 없습니다.");
		         	 
	         };
	         
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
	}
	
	public boolean insert(BookVo bookVo) {
	     Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      try {

	         conn = getConnection();
	         String sql = "insert into book values(null, ?, '대여가능', ?)";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setString(1, bookVo.getTitle());
	         pstmt.setLong(2, bookVo.getAuthorNo());

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
	
	public boolean updateStatus(long no , String status) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      
	      try {
		         conn = getConnection();
		         String sql = "update book set status = ? where no= ?";
		         pstmt = conn.prepareStatement(sql);

		         pstmt.setString(1, status);
		         pstmt.setLong(2, no);

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
