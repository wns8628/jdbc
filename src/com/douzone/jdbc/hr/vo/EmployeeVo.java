package com.douzone.jdbc.hr.vo;

public class EmployeeVo {
  private String name;
  private String gender;
  private String hireDate;
  
	@Override
	public String toString() {
		return "EmployeeVo [name=" + name + ", gender=" + gender + ", hireDate=" + hireDate + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
  

}
