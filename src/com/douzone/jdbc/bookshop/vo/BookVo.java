package com.douzone.jdbc.bookshop.vo;

public class BookVo {

	private long no; 
	private String title; 
	private String status; 
//	private AuthorVo author; //값을가진 객체라서 이렇게하면안된다. 
	private String AuthorName; 
	private long authorNo;
	
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", status=" + status + ", AuthorName=" + AuthorName
				+ ", authorNo=" + authorNo + "]";
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public long getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(long authorNo) {
		this.authorNo = authorNo;
	} 
	 
	
}
