package day20210529;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectOneTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("조회하고자 하는 책 id를 입력해주세요");
		int bookId = sc.nextInt();
		
		BookDao dao = new BookDao();
		
	
		try {
			BookDto bookDto = dao.selectOneById(bookId);
			
			System.out.println("조회댄 책은");
			if(bookDto != null) System.out.println(bookDto);
			else System.out.println("없당!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
