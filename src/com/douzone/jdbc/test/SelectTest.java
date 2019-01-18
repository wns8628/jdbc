package com.douzone.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			// 1.JDBC Driver(MySQL) 로딩 	- 라이브러리 등록 후 해야함		
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기 	  - 프로토콜  htpp같은-  	--연결 : 커넥션객체 얻어오기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); //mysql -u webdb -D webdb -p webdb 이걸한거
						
			//3. Statement 객체를 생성 - 쿼리를 떄리기 위해 
			stmt = conn.createStatement();
			
			//4. SQL문 실행 
			String sql = "select name,owner,birth from pet";
			rs = stmt.executeQuery(sql); //결과가있으니 받아야겠지 리턴값은 ResultSet
			
			//5. 결과 가져오기
			while(rs.next()) {
				String name = rs.getString(1); //0이아니라 DB에서는 1임 
				String owner = rs.getString(2);
				String birth = rs.getString(3);
				
				System.out.println(name + ":"+ 
							       owner + ":" +
						           birth);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:"+ e);			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
