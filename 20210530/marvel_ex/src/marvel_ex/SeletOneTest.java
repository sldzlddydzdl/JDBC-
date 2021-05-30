package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SeletOneTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Connection conn = MyConnection.getConn();
			
			MarvelDao marvelDao = MarvelDao.getInstance();
			
			System.out.println("조회할 아이디를 입력해주세요");
			int movieId = Integer.parseInt(sc.nextLine());
			
			MarvelDto selectOneMovie = marvelDao.selectByOne(conn, movieId);
			
			System.out.println(selectOneMovie);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
