package com.douzone.jdbc.hr;

import java.util.Scanner;

import com.douzone.jdbc.bookshop.dao.BookDao;
import com.douzone.jdbc.hr.test.EmployeeDao;

public class HRApp {
	public static void main(String[] args) {
		System.out.print("사원이름을 입력하세요");
		Scanner scanner = new Scanner(System.in);			
		String name = scanner.toString();
		
		search(name);
		
	}

	private static void search(String name) {
		
		new EmployeeDao().getList();
		
	}	
}
