package day20210530;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectTitleTest {

	public static void main(String[] args) {
		try {
			Connection conn = MyConn.getConn();
			
			BookDao bookDao = BookDao.getInstance();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("찾으려는 제목을 입력하세요");
			String title = sc.nextLine();
			
			List<BookDto> bookList = bookDao.selectListByTitle(conn, title);
			
			for (BookDto bookDto : bookList)
				System.out.println(bookDto);
			
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
