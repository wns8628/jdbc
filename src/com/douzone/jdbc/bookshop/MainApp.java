package com.douzone.jdbc.bookshop;

import java.util.List;
import java.util.Scanner;

import com.douzone.jdbc.bookshop.dao.BookDao;
import com.douzone.jdbc.bookshop.vo.BookVo;

public class MainApp {
	
	public static void main(String[] args) {

		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		Scanner scanner = new Scanner(System.in);		
		long no = scanner.nextLong();
		scanner.close();

		rent(no);  //이렇게하면 다우접근코드가없다.
		
		System.out.println("===도서정보출력=====");
		displayBookInfo();

	}
	
	
	public static void rent(long no) {
		BookDao b = new BookDao();
		b.select_Rent(no);
		b.updateStatus(no,"대여중");
		
	}
	
	
	public static void displayBookInfo() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo:list) {
			System.out.println("책 제목:"+ vo.getTitle() + 
								", 저자:" + vo.getAuthorName() +
								", 대여 유무:" + vo.getStatus()
							  );
		}
	}
	
	
}
