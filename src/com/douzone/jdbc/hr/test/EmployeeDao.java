package com.douzone.jdbc.hr.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.jdbc.hr.vo.EmployeeVo;

public class EmployeeDao {
	
	public List<EmployeeVo> getSearchList(String search) {
	      List<EmployeeVo> list = new ArrayList<EmployeeVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select concat(first_name,' ',last_name) as '이름', gender, hire_date" + 
	         		"  from employees" + 
	         		" where concat(first_name,' ',last_name) like '%" + search +"%'";
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기 이름,성,고용일
	         while (rs.next()) {
	        	String name = rs.getString(1);
	            String gender = rs.getString(2);
	            String hireDate = rs.getString(3); 

	            EmployeeVo vo = new EmployeeVo();
	            
	            vo.setName(name);
	            vo.setGender(gender);
	            vo.setHireDate(hireDate);

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
	
	
	public List<EmployeeVo> getList() {
	      List<EmployeeVo> list = new ArrayList<EmployeeVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select concat(first_name,' ',last_name) as '이름', gender, hire_date" + 
	         		"  from employees";
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기 이름,성,고용일
	         while (rs.next()) {
	        	String name = rs.getString(1);
	            String gender = rs.getString(2);
	            String hireDate = rs.getString(3); 

	            EmployeeVo vo = new EmployeeVo();
	            
	            vo.setName(name);
	            vo.setGender(gender);
	            vo.setHireDate(hireDate);

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
	

	   private Connection getConnection() throws SQLException {
	      Connection conn = null;

	      try {
	         Class.forName("com.mysql.jdbc.Driver"); // 패키지 이름

	         String url = "jdbc:mysql://localhost:3306/employees"; // DB 종류마다 url이 다르다
	         conn = DriverManager.getConnection(url, "hr", "hr"); // interface
	      } catch (ClassNotFoundException e) {
	         System.out.println("드라이버 로딩 실패" + e);
	      }
	      return conn;
	   }

}
