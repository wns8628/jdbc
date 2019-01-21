package com.douzone.jdbc.hr;

import java.util.List;
import java.util.Scanner;

import com.douzone.jdbc.bookshop.dao.BookDao;
import com.douzone.jdbc.bookshop.vo.BookVo;
import com.douzone.jdbc.hr.test.EmployeeDao;
import com.douzone.jdbc.hr.vo.EmployeeVo;

public class HRApp {
	public static void main(String[] args) {
		System.out.print("사원이름을 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);			
		String name = scanner.nextLine();
		
		search(name);		
	}

	private static void search(String name) {
		List<EmployeeVo> list = new EmployeeDao().getSearchList(name);
		for(EmployeeVo vo:list) {
			System.out.println("이름 :" + vo.getName() + 
							", 성:" + vo.getGender() +
							", 고용일:" + vo.getHireDate());
		}
	}	
}
