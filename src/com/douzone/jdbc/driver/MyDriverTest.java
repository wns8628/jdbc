package com.douzone.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDriverTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 1.JDBC Driver(MySQL) 로딩 	- 라이브러리 등록 후 해야함		
			Class.forName("com.douzone.jdbc.driver.MyDriver");
			
			// 2.연결하기 	  - 프로토콜  htpp같은-             --연결 : 커넥션객체 얻어오기
			String url = "jdbc:mysql://localhost:3306/";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); //mysql -u webdb -D webdb -p webdb 이걸한거						
			System.out.println("연결성공");
			
		} catch (ClassNotFoundException e) { 
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:"+ e);			
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
