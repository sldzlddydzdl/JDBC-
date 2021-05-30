package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectHowManyTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇개의 데이터를 조회하실건가요?");
		int num = Integer.parseInt(sc.nextLine());
		
		try {
			Connection conn = MyConnection.getConn();
			
			MarvelDao marvelDao = MarvelDao.getInstance();
			
			List<MarvelDto> movieList = marvelDao.selectHowMany(conn, num);
			
			for(MarvelDto movies : movieList) {
				System.out.println(movies);
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
