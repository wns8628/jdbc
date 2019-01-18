package com.douzone.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) {
		boolean result = update("마으미", "김세준", "f");
		System.out.println(result);
	}

	public static boolean update(String name,String owner, String gender) {
		
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =null; //준비하다 .쿼리를 준비시켜놓는다.
		
		try {
			// 1.JDBC Driver(MySQL) 로딩 	- 라이브러리 등록 후 해야함		
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기 	  - 프로토콜  htpp같은-  	--연결 : 커넥션객체 얻어오기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); //mysql -u webdb -D webdb -p webdb 이걸한거
						
			//3. SQL문 준비
			String sql= "update pet set owner=?, gender =? where name=?";
			pstmt = conn.prepareStatement(sql); //쿼리를 준비시킨다 때리지 말구
			
			//4. 바인딩
			pstmt.setString(1, owner);
			pstmt.setString(2, gender);
			pstmt.setString(3, name);
			
			//5. SQL문 실행
			int count = pstmt.executeUpdate();
			result = count >= 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:"+ e);			
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
