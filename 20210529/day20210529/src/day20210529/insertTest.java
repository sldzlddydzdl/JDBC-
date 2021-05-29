package day20210529;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class insertTest {
	
	public static void main(String[] args) {
		
		BookDao dao = new BookDao();
		
		Scanner sc = new Scanner(System.in);
		
//		BookDto bookDto = new BookDto(0, null, null, null, 0, null, null)
		System.out.println("제목을 입력하세요");
		String title = sc.nextLine();
		
		System.out.println("부제목을 입력하세요");
		String subTitle = sc.nextLine();
		
		System.out.println("작가를 입력하세요");
		String publisher = sc.nextLine();
		
		System.out.println("가격을 입력하세요");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.println("출판일을 입력하세요(형식 yyyy-mm-dd)");
		String publicationDate = sc.nextLine();
		
		BookDto bookDto = new BookDto(0, title, subTitle, publisher,
				price, LocalDate.parse(publicationDate), LocalDateTime.now());
		
		try {
			int affectedRows = dao.insert(bookDto);
			
			System.out.println("삽입된 로우 수 : " + affectedRows);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
