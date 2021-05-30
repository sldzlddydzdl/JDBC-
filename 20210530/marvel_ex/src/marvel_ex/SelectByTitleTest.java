package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectByTitleTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Connection conn = MyConnection.getConn();
			
			MarvelDao marvelDao = MarvelDao.getInstance();
			
			System.out.println("찾을 제목을 입력해주세요");
			String title = sc.nextLine();
			
			List<MarvelDto> movieList = marvelDao.selectByTitle(conn, title);

			if(movieList.size() > 0) {
				for(MarvelDto movies : movieList) {
					System.out.println(movies);
				}
			}else {
				System.out.println("해당 언어가 포함된 영화제목은 없습니다.");
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
