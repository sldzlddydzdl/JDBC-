package day20210530;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class UpdateTest {
	public static void main(String[] args) {
		
		// 어떤 컬럼을 수정할지 알아야 한다.
		// 수정하는 컬럼은 값을 받고
		// 수정하지 않는 컬럼은 기존값을 다시 넣음 ( 조회 를 한번해야한다 )
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 책의 id를 입력하세요");
		
		int bookId = Integer.parseInt(sc.nextLine());
		
		try (Connection conn = MyConn.getConn()){
			// 데이터 조회
			BookDao dao = BookDao.getInstance();
			BookDto bookDto = dao.selectOneById(conn, bookId); 
			
			System.out.println("수정할 제목을 입력하세요 수정하지 않으려면 엔터");
			String title = sc.nextLine();
			if(!title.equals("")) {
				bookDto.setTitle(title);
			}
			
			System.out.println("수정할 작가를 입력하세요 수정하지 않으려면 엔터");
			String publisher = sc.nextLine();
			if(!publisher.equals("")) {
				bookDto.setPublisher(publisher);
			}
			
			System.out.println("수정할 부제목을 입력하세요 수정하지 않으려면 엔터");
			String subTitle = sc.nextLine();
			if(!subTitle.equals("")) {
				bookDto.setSub_title(subTitle);
			}
			
			System.out.println("수정할 가격을 입력하세요 수정하지 않으려면 엔터");
			String price = sc.nextLine();
			if(!price.equals("")) {
				bookDto.setPrice(Integer.parseInt(price));
			}
			
			System.out.println("수정할 출판일을 입력하세요(형식 : 'yyyy-MM-dd') 수정하지 않으려면 엔터");
			String publicationDate = sc.nextLine();
			if(!publicationDate.equals("")) {
				bookDto.setPublicationDate(LocalDate.parse(publicationDate));
			}
			
			// 수정된 객체를 이용하여 업데이트 한다.
			int affectedRst = dao.updateBook(conn, bookDto);
			
			if(affectedRst > 0) {
//				bookDto = dao.selectOneById(conn, bookId); 
				System.out.println("수정된 값 : " + bookDto);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}













