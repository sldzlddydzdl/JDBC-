package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 영화의 id 를 입력해주세요");
		
		int movieId = Integer.parseInt(sc.nextLine());
		
		try {
			Connection conn = MyConnection.getConn();
			
			MarvelDao marvelDao = MarvelDao.getInstance();
			MarvelDto marvelDto = marvelDao.selectByOne(conn, movieId);
			
			System.out.println("수정할 제목을 입력해주세요 [ 수정안할거면 엔터를 눌러주세요 ]");
			String title = sc.nextLine();
			if(!title.equals("")) { // 빈문자열이 아니면 제목이 그대로 수정된다.
				marvelDto.setTitle(title);
			}
			
			System.out.println("수정할 영어제목을 입력해주세요 [ 수정안할거면 엔터를 눌러주세요 ]");
			String engTitle = sc.nextLine();
			if(!engTitle.equals("")) {
				marvelDto.setTitleEng(engTitle);
			}
			
			System.out.println("수정할 개봉일을 입력해주세요 ( 형식 : yyyy-mm-dd ) [ 수정안할거면 엔터를 눌러주세요 ]");
			String realeaseDate = sc.nextLine();
			if(!realeaseDate.equals("")) {
				marvelDto.setReleaseDate(LocalDate.parse(realeaseDate));
			}
			
			System.out.println("수정할 월드박스 오피스를 입력해주세요 [ 수정안할거면 엔터를 눌러주세요 ]");
			String worldBoxOffice = sc.nextLine();
			if(!worldBoxOffice.equals("")) {
				marvelDto.setWorldBoxOffice(Long.parseLong(worldBoxOffice));
			}
			
			int affectedRow = marvelDao.update(conn, marvelDto);
			
			System.out.println(affectedRow + " 만큼 수정됬습니다.");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
