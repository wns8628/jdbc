package com.douzone.jdbc.hr.dao;

import java.util.List;

import com.douzone.jdbc.hr.test.EmployeeDao;
import com.douzone.jdbc.hr.vo.EmployeeVo;

public class EmployeeDaoTest {
	
	public static void main(String[] args) {
		getlistTest();
	}
	
	public static void getlistTest() {
		List<EmployeeVo> list = new EmployeeDao().getList();
		for(EmployeeVo vo:list) {
			System.out.println(vo);
		}
	}

}
