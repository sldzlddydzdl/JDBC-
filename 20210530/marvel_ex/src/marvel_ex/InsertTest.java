package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class InsertTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영화제목을 입력해주세요 ");
		String title = sc.nextLine();
		
		System.out.println("영화제목을 영어로 입력해주세요");
		String engTitle = sc.nextLine();
		
		System.out.println("개봉일을 입력해주세요 (형식 : 'yyyy-mm-dd') ");
		String releaseDate = sc.nextLine();
		
		System.out.println("월드박스오피스는 얼마인지 입력해주세요 ");
		String worldBoxOffice = sc.nextLine();
		
		MarvelDto marvelDto = new MarvelDto(0,
				title,
				engTitle,
				LocalDate.parse(releaseDate),
				Long.parseLong(worldBoxOffice),
				LocalDateTime.now(),
				LocalDateTime.now());
		
		try(Connection conn = MyConnection.getConn()){
		
					
			MarvelDao marvelDao = MarvelDao.getInstance();
//			BookDto bookDto = dao.selectOneById(conn, bookId); 
			
			int affectedrow =  marvelDao.insert(conn, marvelDto);
			
			System.out.println(affectedrow + " 열이 추가되었습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
