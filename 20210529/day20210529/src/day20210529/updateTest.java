package day20210529;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class updateTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 책의 id를 입력하세요");
		int bookId = Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 제목을 입력하세요");
		String title = sc.nextLine();
		
		System.out.println("수정할 부제목을 입력하세요");
		String subTitle = sc.nextLine();
		
		System.out.println("수정할 작가를 입력하세요");
		String publisher = sc.nextLine();
		
		System.out.println("수정할 가격을 입력하세요");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 발행일을 입력하세요(yyyy-mm-dd)");
		LocalDate publicationDate = LocalDate.parse(sc.nextLine());
		
		LocalDateTime regDate = LocalDateTime.now();
		
		BookDto bookDto = new BookDto(bookId, title, subTitle, publisher, price, publicationDate, regDate);
		
		BookDao bookDao = new BookDao();
		try {
			int affectedRow = bookDao.update(bookDto);
			
			System.out.println(affectedRow + " 로우수가 수정 되었습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
