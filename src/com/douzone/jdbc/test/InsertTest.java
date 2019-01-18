package com.douzone.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		boolean result = insert("마음이10","또치10","dog","f","2010-10-10",null);
		System.out.println(result);
	}
//	public static void insert(PetVO pet) 이게필요함 인자가많으면

	public static boolean insert(String name, String owner, String species, String gender, String birth, String daeth) {
		
		Connection conn = null;
		Statement stmt =null;
		boolean result =false;
		
		try {
			// 1.JDBC Driver(MySQL) 로딩 	- 라이브러리 등록 후 해야함		
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기 	  - 프로토콜  htpp같은-  	--연결 : 커넥션객체 얻어오기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); //mysql -u webdb -D webdb -p webdb 이걸한거
						
			//3. Statement 객체를 생성 - 쿼리를 떄리기 위해 
			stmt = conn.createStatement();
	
			//4. SQL문 실행 
			String sql = 
					"insert " +
					"into pet " + 
					"values ('" + 
							 	name + "','" + 
							 	owner  + "','" +
							 	species+"', '"+ 
							 	gender +"', '"+
							 	birth +"', null)";
			int count = stmt.executeUpdate(sql);
			result = count >= 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:"+ e);			
		} finally {
			try {
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
		return result;		
	}
}
